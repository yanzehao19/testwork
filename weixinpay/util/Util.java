package util;

import org.apache.commons.codec.digest.DigestUtils;

import entity.UnifiedOrder;

public class Util {
	 /**
     * 统一下单
     * @Title: unifiedOrder 
     * @Description: TODO 
     * @param: @param openId 微信用户openId
     * @param: @param orderId 订单ID
     * @param: @param money 订单总价，单位：分
     * @param: @param callbackUrl 回调路径
     * @param: @return
     * @param: @throws Exception
     * @return: String
     */
	  public String unifiedOrder(String openId,String orderId,int money,String callbackUrl) throws Exception{
	        UnifiedOrder unifiedOrder = new UnifiedOrder();
	        unifiedOrder.setAppid(appId);
	        unifiedOrder.setAttach("hehedesk");

	        unifiedOrder.setBody("hehedesk");
	        unifiedOrder.setMch_id(mchId);

	        String nonce = UUID.randomUUID().toString().substring(0, 30);
	        unifiedOrder.setNonce_str(nonce);
	        unifiedOrder.setNotify_url(callbackUrl);

	        unifiedOrder.setOpenid(openId);
	        unifiedOrder.setOut_trade_no(orderId);

	        unifiedOrder.setSpbill_create_ip("14.23.150.211");
	        unifiedOrder.setTotal_fee(money);

	        String sign = createUnifiedOrderSign(unifiedOrder);
	        unifiedOrder.setSign(sign);

	        /**
	         * 转成XML格式
	         */
	        xmlUtil.getXstreamInclueUnderline().alias("xml", unifiedOrder.getClass());
	        String xml = xmlUtil.getXstreamInclueUnderline().toXML(unifiedOrder);

	        String response = httpConnection.post(unifiedOrderUrl, xml);
	        logger.info("unifiedOrder");
	        logger.info(response);
	        Map<String, String> responseMap = xmlUtil.parseXml(response);

	        return responseMap.get("prepay_id");
	    }
	  
	  
	  
	  /**
	     * 获取统一下单签名
	     * @Title: createUnifiedOrderSign
	     * @Description: TODO
	     * @param @param unifiedOrder
	     * @param @return    
	     * @return String    
	     * @throws
	     */
	    public String createUnifiedOrderSign(UnifiedOrder unifiedOrder){
	        StringBuffer sign = new StringBuffer();
	        sign.append("appid=").append(unifiedOrder.getAppid());
	        sign.append("&attach=").append(unifiedOrder.getAttach());
	        sign.append("&body=").append(unifiedOrder.getBody());
	        sign.append("&device_info=").append(unifiedOrder.getDevice_info());
	        sign.append("&mch_id=").append(unifiedOrder.getMch_id());
	        sign.append("&nonce_str=").append(unifiedOrder.getNonce_str());
	        sign.append("&notify_url=").append(unifiedOrder.getNotify_url());
	        sign.append("&openid=").append(unifiedOrder.getOpenid());
	        sign.append("&out_trade_no=").append(unifiedOrder.getOut_trade_no());
	        sign.append("&spbill_create_ip=").append(unifiedOrder.getSpbill_create_ip());
	        sign.append("&total_fee=").append(unifiedOrder.getTotal_fee());
	        sign.append("&trade_type=").append(unifiedOrder.getTrade_type());
	        sign.append("&key=").append(payKey);

	        return DigestUtils.md5Hex(sign.toString()).toUpperCase();
	    }
	    /**
	     * 获取统一下单签名
	     * @Title: createUnifiedOrderSign
	     * @Description: TODO
	     * @param @param unifiedOrder
	     * @param @return    
	     * @return String    
	     * @throws
	     */
	    public String createUnifiedOrderSign(UnifiedOrder unifiedOrder){
	        StringBuffer sign = new StringBuffer();
	        Map<String, String> map = getSortMap(unifiedOrder);

	        boolean isNotFirst = false;

	        for (Map.Entry<String, String> entry : map.entrySet()) {
	            if(isNotFirst == true){
	                sign.append("&");
	            }else{
	                isNotFirst = true;
	            }

	            sign.append(entry.getKey()).append("=").append(entry.getValue());
	        }
	        sign.append("&key=").append(payKey);

	        return DigestUtils.md5Hex(sign.toString()).toUpperCase();

	    }


	    /**
	     * 获取排序后的类属性及值
	     * @param object
	     * @return
	     * @throws Exception
	     */
	    private Map<String, String> getSortMap(Object object) throws Exception{
	        Field[] fields = object.getClass().getDeclaredFields();
	        Map<String, String> map = new HashMap<String, String>();

	        for(Field field : fields){
	             String name = field.getName();
	             String methodName = "get" + name.replaceFirst(name.substring(0, 1), name.substring(0, 1)
	                     .toUpperCase());
	             Method getter = object.getClass().getMethod(methodName);
	             // 调用getter方法获取属性值
	             String value =  getter.invoke(object)+"";
	             if (value != null){
	                 map.put(name, value);
	             }
	        }

	        Map<String, String> sortMap = new TreeMap<String, String>(
	                new Comparator<String>() {

	                    @Override
	                    public int compare(String arg0, String arg1) {

	                        return arg0.compareTo(arg1);
	                    }

	                });

	        sortMap.putAll(map);

	        return sortMap;
	    }
	    
	    
	    /**
	     * 获取支付配置
	     * @Title: createPayConfig
	     * @Description: TODO
	     * @param @param preayId 统一下单prepay_id
	     * @param @return
	     * @param @throws Exception    
	     * @return JsAPIConfig    
	     * @throws
	     */
	    public JsAPIConfig createPayConfig(String prepayId) throws Exception {
	        JsAPIConfig config = new JsAPIConfig();

	        String nonce = UUID.randomUUID().toString();
	        String timestamp = Long.toString(System.currentTimeMillis() / 1000);
	        String packageName = "prepay_id="+prepayId;
	        StringBuffer sign = new StringBuffer();
	        sign.append("appId=").append(appId);
	        sign.append("&nonceStr=").append(nonce);
	        sign.append("&package=").append(packageName);
	        sign.append("&signType=").append(config.getSignType());
	        sign.append("&timeStamp=").append(timestamp);
	        sign.append("&key=").append(payKey);
	        String signature = DigestUtils.md5Hex(sign.toString()).toUpperCase();

	        config.setAppId(appId);
	        config.setNonce(nonce);
	        config.setTimestamp(timestamp);
	        config.setPackageName(packageName);
	        config.setSignature(signature);

	        return config;
	    }
	    
	    
	    /**
	     * 微信支付回调页面
	     * @Title: wechatPayNotify
	     * @Description: TODO
	     * @param @param request
	     * @param @param trade_status
	     * @param @param out_trade_no
	     * @param @param trade_no    
	     * @return void    
	     * @throws
	     */
	    @ResponseBody 
	    @RequestMapping(value="wechat_notify")
	    public String wechatPayNotify(HttpServletRequest request){
	        try {
	             Map<String, String> map = getCallbackParams(request);
	             if (map.get("result_code").toString().equalsIgnoreCase("SUCCESS")) {
	                 String orderId = map.get("out_trade_no");
	                 //这里写成功后的业务逻辑
	                 orderService.updateConfirm(orderId);
	             }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return wechatMerchantFactory.getPayCallback(); 
	    }
	    /**
	     * 获取请求参数
	     * @Title: getCallbackParams
	     * @Description: TODO
	     * @param @param request
	     * @param @return
	     * @param @throws Exception    
	     * @return Map<String,String>    
	     * @throws
	     */
	    public Map<String, String> getCallbackParams(HttpServletRequest request)
	            throws Exception {
	        InputStream inStream = request.getInputStream();
	        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
	        byte[] buffer = new byte[1024];
	        int len = 0;
	        while ((len = inStream.read(buffer)) != -1) {
	            outSteam.write(buffer, 0, len);
	        }
	        System.out.println("~~~~~~~~~~~~~~~~付款成功~~~~~~~~~");
	        outSteam.close();
	        inStream.close();
	        String result = new String(outSteam.toByteArray(), "utf-8");
	        return xmlUtil.parseXml(result);
	    }
}
