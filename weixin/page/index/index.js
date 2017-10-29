Page({
  data: {
    userInfo: {},
    motto: 'Hello World',
    //orderItems
    orderItems1: [
      {
        typeId: 0,
        name: '美食',
        url: 'bill',
        imageurl: '../../image/home/cone.png',
      },
      {
        typeId: 1,
        name: '甜品饮品',
        url: 'bill',
        imageurl: '../../image/home/cone.png',
      },
      {
        typeId: 2,
        name: '商超便利',
        url: 'bill',
        imageurl: '../../image/home/drupstick.png'
      },
      {
        typeId: 3,
        name: '果蔬生鲜',
        url: 'bill',
        imageurl: '../../image/home/hamberger.png'
      }
    ],
    orderItems2: [
      {
        typeId: 0,
        name: '新店优惠',
        url: 'bill',
        imageurl: '../../image/home/cone.png',
      },
      {
        typeId: 1,
        name: '大牌必吃',
        url: 'bill',
        imageurl: '../../image/home/cone.png',
      },
      {
        typeId: 2,
        name: '果蔬',
        url: 'bill',
        imageurl: '../../image/home/drupstick.png'
      },
      {
        typeId: 3,
        name: '超市',
        url: 'bill',
        imageurl: '../../image/home/hamberger.png'
      }
    ],

    orderItems3: [
      {
        typeId: 0,
        name: '美食',
        url: 'bill',
        imageurl: '../../image/home/cone.png',
      },
      {
        typeId: 1,
        name: '甜品',
        url: 'bill',
        imageurl: '../../image/home/cone.png',
      },
      {
        typeId: 2,
        name: '果蔬',
        url: 'bill',
        imageurl: '../../image/home/drupstick.png'
      },
      {
        typeId: 3,
        name: '超市',
        url: 'bill',
        imageurl: '../../image/home/hamberger.png'
      }
    ],
    imgUrls: [
      "http://mz.djmall.xmisp.cn/files/adver/20161215/14817887834.png",
      "http://mz.djmall.xmisp.cn/files/banner/20161215/148178785820.jpg",
    ],

    recommendshop: [
      {
        imageurl: '../../image/home/hamberger.png',
        name: '金拱门汉堡',
        safe: '保',
        evaluate: '好评',
        promise: '准时达|蜂鸟配送',
        send: '￥10起送|配送费￥4',
        distance: '10km',
      },
      {
        imageurl: '../../image/home/hamberger.png',
        name: '金拱门汉堡',
        safe: '保',
        evaluate: '好评',
        promise: '准时达|蜂鸟配送',
        send: '￥10起送|配送费￥4',
        distance: '10km',
      },
    ],
  },

  toOrder: function () {
    wx.navigateTo({
      url: '../food/food',
    })
    wx.request({
      url:  'http://localhost:8080/SpringSpringMVCMyBatis/user/showUser?id=1', //仅为示例，并非真实的接口地址
      data: {
        id: '1',
      },
      method:'get',
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        console.log(res.data)
      }
    })
 
  }
})