package file;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成某一订单好的对账文件
 * 
 * @author yzh
 *
 */
public class ProductOrderNo {
	public void productOrderNo() {
		String [] strings={
"2017-12-15 00:03:07	20171215	1300303011513267314732264		171214420042685	成功	***************0000		100.00	100.00	0.00	100.00	002809295	银联	他行卡		1				--	--	",
"2018-01-02 20:21:03	20180102	1300303011514895615772318		171211420026814	成功	***************0000		100.00	100.00	0.00	100.00	002809295	银联	他行卡		1				--	--"	,
"2017-12-27 08:37:42	20171227	1300303011514335032784199		171226420000959	成功	***************0000		20.00	20.00	0.00	20.00	002809295	银联	他行卡		1				--	--	",
"2017-12-12 10:24:03	20171212	1300303011513045377346003		171211420027069	成功	***************0000		700.00	700.00	0.00	700.00	002809295	银联	他行卡		1				--	--	"
		};
		List list = new ArrayList<>();
		ArrayList<String> strArray = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			String str = "";
			String s = list.get(i).toString();
			String[] re = s.split("	");// 用split()函数直接分割
			// 查询订单号对应的信息
			String yesterdayTime = "";
			String orderNo = re[4];
			PayRecord payRecord = msgDao.queryPayRecord(orderNo, null);
			// 查询财政执收单位等信息，进行拆分多条
			List<RecordFee> recordFeeResult = msgDao.queryRecordFeeByOrderNo(orderNo);
			int size = recordFeeResult.size();
			System.out.println("订单号为" + orderNo + "拆分为：" + size + "笔");
			if (size > 0) {
				for (int j = 0; j < size; j++) {
					// 查询子订单数据
					String OrderData = createOrderData(recordFeeResult.get(j).getId().toString());
					// 将3001业务代码修改成3002
					if ("3001".equals(payRecord.getBusCode())) {
						payRecord.setBusCode("3002");
					}
					str = recordFeeResult.get(j).getSum() + "|" + "2" + "|"
							+ re[0].substring(0, 10).replace("-", "") + "|"
							+ re[0].substring(11, 19).replace(":", "") + "|"
							+ payRecord.getPayerName() + "|" + re[6] + "|" + "" + "|" + "" + "|"
							+ (recordFeeResult.get(j).getTransacNo() == null
									|| "null".equals(recordFeeResult.get(j).getTransacNo()) ? ""
											: recordFeeResult.get(j).getTransacNo())
							+ "|" + recordFeeResult.get(j).getOrgUnicode() + "|" + orderNo + "|"
							+ re[0] + "|" + payRecord.getBusCode() + "|" + OrderData + "|"
							+ (payRecord.getRemark1() == null
									|| "null".equals(payRecord.getRemark1()) ? ""
											: payRecord.getRemark1())
							+ "|"
							+ (payRecord.getRemark2() == null
									|| "null".equals(payRecord.getRemark2()) ? ""
											: payRecord.getRemark2())
							+ "|"
							+ (payRecord.getRemark3() == null
									|| "null".equals(payRecord.getRemark3()) ? ""
											: payRecord.getRemark3())
							+ "|";
					strArray.add(str);
					System.out.println("+++++++++"+str);
					System.out.println("订单号" + orderNo + "的第" + (j + 1) + "笔金额为：" + recordFeeResult.get(j).getSum());
				}
			} else {
				return;
			}
		}

	}
}
