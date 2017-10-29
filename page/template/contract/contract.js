var iconList={}//设置一个对象名字存放数据
iconList.Wdg={
  //存放数据和方法
  data: {
    // input默认是1  
    num:1,
    // 使用data数据对象设置样式名  
    minusStatus: 'disabled'
  },
  /* 点击减号 */
  bindMinus: function (event) {
    debugger
    var componentId = event.currentTarget.dataset.componentid;
    var num = this.data.carts[componentId].count.quantity;
    
    // 如果大于1时，才可以减  
    if (num > 1) {
      num--;
    }
    this.data.carts[componentId].count.quantity = num;
    // 只有大于一件的时候，才能normal状态，否则disable状态  
    var minusStatus = num <= 1 ? 'disabled' : 'normal';
    // 将数值与状态写回  
    this.setData({
      carts: this.data.carts,
      minusStatus: minusStatus
    });
  },
  /* 点击加号 */
  bindPlus: function (event) {
    debugger;
    var componentId = event.currentTarget.dataset.componentid;
    console.log(event.currentTarget.dataset.componentid);
    var num = this.data.carts[componentId].count.quantity;
    // 不作过多考虑自增1  
    
    num++;
    this.data.carts[componentId].count.quantity=num;
    // 只有大于一件的时候，才能normal状态，否则disable状态  
    var minusStatus = num < 1 ? 'disabled' : 'normal';
    // 将数值与状态写回 
    debugger 
    this.setData({
      carts: this.data.carts,
      minusStatus: minusStatus
    });
    console.log(this.data)
  },
  /* 输入框事件 */
  bindManual: function (e) {
    var num = e.detail.value;
    // 将数值与状态写回  
    this.setData({
      num: num
    });
  }
}
module.exports = iconList//将接口的进行暴露，方便在外面调用