<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="utf-8">
        <title>菜鸟教程(runoob.com)</title></head>
    
    <body>
        <p>查找最大的数。</p>
        <p id="demo"></p>
        <script>// 函数提升Hoisting
            myFunction(5);

            function myFunction(a, b) {
                return a * b;
            }

            var x = function(a, b) {
                return a * b
            };
            var z = x(4, 3);

            var myFunction = new Function("a", "b", "return a*b");
            var x = myFunction(4, 3);

            (function() {
                var x = "hello";
            })();

            function myFunction(a, b) {
                return a * b;
            }
            var x = myFunction(4, 3);
            var x = myFunction(4, 3) * 2;

            function myFunction(a, b) {
                return arguments.length;
            }

            function myFunction(a, b) {
                return a * b;
            }
            var txt = myFunction.toString();

            x = findMax(1, 123, 50, 115, 44, 88);

            function findMax() {
                var i, max = arguments[0];
                if (arguments.length < 2) return max;
                for (i = 0; i < arguments.length; i++) {
                    if (arguments[i] > max) {
                        max = arguments[i];
                    }
                }
                return max;
            }

            function myFunction(a, b) {
                return a * b;
            }
            window.myFunction(10, 2);

            var myObject = {
                firstName: "Johe",
                lastName: "Doe",
                fullName: function() {
                    return this.firstName + " " + this.lastName;
                }
            }

            myObject.fullName();

            // 构造函数的调用会创建一个新的对象。新对象会继承构造函数的属性和方法。
            // 构造函数中 this 关键字没有任何的值。
            // this 的值在函数调用时实例化对象(new object)时创建。
            function myFunction(arg1, arg2) {
                this.firstName = arg1;
                this.lastName = arg2;
            }

            var x = new myFunction("John", "Doe");
            x.firstName;
            
            function myFunction(a,b){
            	return a*b;
            }
            myObject=myFunction.call(myObject,10,2);
            
            function myFunction(a,b){
            	return a*b;
            }
            myArray=[10,2];
            myObject=myFunction.apply(myObject,myArray);
            
            function add(){
            	var counter=0;
            	function plus(){counter+=1;}
            	plus();
            	return conter;
            }
            
            var add=(function(){
            	var counter=0;
            	return function(){return counter+=1;}
            })();
            add();
            add();
            add();
            
            
            </script>
    </body>

</html>