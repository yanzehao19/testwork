Page({
  data: {
    cateItems: [
      {
        cate_id: 1,
        cate_name: "护肤",
        ishaveChild: true,
        children:
        [
          {
            child_id: 1,
            name: '洁面皂',
            image: "http://mz.djmall.xmisp.cn/files/logo/20161208/148117972563.jpg"
          },
          {
            child_id: 2,
            name: '卸妆',
            image: "http://mz.djmall.xmisp.cn/files/logo/20161207/148110444480.jpg"
          },
          {
            child_id: 3,
            name: '洁面乳',
            image: "http://mz.djmall.xmisp.cn/files/logo/20161208/148117973270.jpg"
          },
          {
            child_id: 4,
            name: '面部祛角质',
            image: "http://mz.djmall.xmisp.cn/files/logo/20161208/148117981591.jpg"
          }
        ]
      },
      {
        cate_id: 2,
        cate_name: "彩妆",
        ishaveChild: true,
        children:
        [
          {
            child_id: 1,
            name: '气垫bb',
            image: "http://mz.djmall.xmisp.cn/files/logo/20161212/14815381301.jpg"
          },
          {
            child_id: 2,
            name: '修容/高光',
            image: "http://mz.djmall.xmisp.cn/files/logo/20161212/14815381411.jpg"
          },
          {
            child_id: 3,
            name: '遮瑕',
            image: "http://mz.djmall.xmisp.cn/files/logo/20161212/148153815181.jpg"
          },
          {
            child_id: 4,
            name: '腮红',
            image: "http://mz.djmall.xmisp.cn/files/logo/20161212/148153815759.jpg"
          },
          {
            child_id: 5,
            name: '粉饼',
            image: "http://mz.djmall.xmisp.cn/files/logo/20161212/148153816983.jpg"
          },
          {
            child_id: 6,
            name: '粉底',
            image: "http://mz.djmall.xmisp.cn/files/logo/20161212/148153817721.jpg"
          },
          {
            child_id: 7,
            name: '蜜粉/散粉',
            image: "http://mz.djmall.xmisp.cn/files/logo/20161212/148153819354.jpg"
          },
          {
            child_id: 8,
            name: '隔离霜',
            image: "http://mz.djmall.xmisp.cn/files/logo/20161215/148179053369.jpg"
          }
        ]
      },
      {
        cate_id: 3,
        cate_name: "香水/香氛",
        ishaveChild: true,
        children:
        [
          {
            child_id: 1,
            name: '淡香水EDT',
            image: "http://mz.djmall.xmisp.cn/files/logo/20161213/14815978910.jpg"
          },
          {
            child_id: 2,
            name: '浓香水EDP',
            image: "http://mz.djmall.xmisp.cn/files/logo/20161213/148159789883.jpg"
          },
          {
            child_id: 3,
            name: '香体走珠',
            image: "http://mz.djmall.xmisp.cn/files/logo/20161213/14815979307.jpg"
          },
          {
            child_id: 4,
            name: '古龙香水男士的最爱',
            image: "http://mz.djmall.xmisp.cn/files/logo/20161213/148159765589.jpg"
          }
        ]
      },
      {
        cate_id: 4,
        cate_name: "个人护理",
        ishaveChild: false,
        children: []
      }
    ],
    curNav: 1,
    curIndex: 0
  },

  //事件处理函数,事件监听，跳转到我的订单界面 
  toOrder: function () {
    wx.navigateTo({
      url: '../detail/detail'
    })
  },
  //下拉刷新
  onPullDownRefresh: function () {
    wx.showNavigationBarLoading() //在标题栏中显示加载

    //模拟加载
    setTimeout(function () {
      // complete
      wx.hideNavigationBarLoading() //完成停止加载
      wx.stopPullDownRefresh() //停止下拉刷新
    }, 1500);
  },


  //事件处理函数  
  switchRightTab: function (e) {
    // 获取item项的id，和数组的下标值  
    let id = e.target.dataset.id,
      index = parseInt(e.target.dataset.index);
    // 把点击到的某一项，设为当前index  
    this.setData({
      curNav: id,
      curIndex: index
    })
  },
  
  //加载更多
  onReachBottom: function () {
    console.log('加载更多')
    setTimeout(() => {
      this.setData({
        isHideLoadMore: true,
        recommends: [
          {
            goodId: 7,
            name: 'OLAY玉兰油精油沐浴露玫瑰滋养二合一450ml',
            url: 'bill',
            imageurl: 'http://mz.djmall.xmisp.cn/files/product/20161213/148162245074.jpg',
            newprice: "￥36.60",
            oldprice: "￥40.00",
          },
          {
            goodId: 10,
            name: '兰蔻玫瑰清滢保湿柔肤水嫩肤水化妆水400ml补水保湿温和不刺激',
            url: 'bill',
            imageurl: 'http://mz.djmall.xmisp.cn/files/product/20161201/148057937593.jpg',
            newprice: "￥30.00",
            oldprice: "￥80.00",
          }, {
            goodId: 11,
            name: 'Lancome/兰蔻清莹柔肤爽肤水/粉水400ml补水保湿玫瑰水化妆水',
            url: 'bill',
            imageurl: 'http://mz.djmall.xmisp.cn/files/product/20161201/148057953326.jpg',
            newprice: "￥30.00",
            oldprice: "￥80.00",
          },
          {
            goodId: 12,
            name: '美国CLINIQUE倩碧黄油无油/特效润肤露125ml',
            url: 'bill',
            imageurl: 'http://mz.djmall.xmisp.cn/files/product/20161201/14805828016.jpg',
            newprice: "￥239.00",
            oldprice: "￥320.00",
          },
          {
            goodId: 13,
            name: '法国LANCOME兰蔻柔皙轻透隔离防晒乳霜50ML2017年3月到期',
            url: 'bill',
            imageurl: 'http://mz.djmall.xmisp.cn/files/product/20161201/148058014894.jpg',
            newprice: "￥130.00",
            oldprice: "￥180.00",
          },
        ],
      })
    }, 1000)
  }

})



