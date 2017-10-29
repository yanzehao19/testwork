var Zan = require('../template/contract/contract.js');
Page(Object.assign({}, Zan.Tab, {
  data: {
    tab1: {
      list: [{
        id: 0,
        title: '全部'
      }, {
        id: 1,
        title: '待付款'
      }, {
        id: 2,
        title: '待发货'
      }, {
        id: 3,
        title: '待收货'
      }, {
        id: 4,
        title: '待评价'
      }],
      selectedId: 0,
      scroll: false,
    },
  },
  handleZanTabChange(e) {
    var componentId = e.componentId;
    var selectedId = e.selectedId;
    this.setData({
      '${componentId}.selectedId': selectedId
    });
  }
}));