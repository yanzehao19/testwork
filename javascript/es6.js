/*
 * let,const
 */
len name='zach'
while(true){
	let name='obama'
	console.log(name)// obama
	break
}
console.log(name)// zach


var a=[]
for(let i=0;i<10;i++){
	a[i]=function(){
		console.log(i);
	};
}
a[6]();

const PI=Math.PI
PI=23// Module build failed:SyntaxError:/es6/app.js:"PI"is read-only



/*
 * class,extends,super
 * 
 */
class Animal{
	constructor(){
		this.type='animal'
	}
	says(say){
		console.log(this.type+'says'+say)
	}
	
}
let animal=new Aniaml()
animal.says('hello')
class Cat extends Animal{
	constructor(){
		super()
		this.type='cat'
	}
}
let cat=new Cat()
cat.says('hello')

/*
 * arrow function
 */
class Animal{
	constructor(){
		this.type='animal'
	}
	says(say){
		setTimeout((=>{
			console.log(this.type+'says'+say)
		},1000))
	}
}

var animal=new Animal()
animal.says("hi")


/*
 * template string
 */
$("#result").append(`
		There are <b>${basket.count}</b> items
		in your basket,<em>${basket.onSale}</em>
		are on sale!
		`)
		
/*
 * destructuring
 */		
let cat='ken'
let dog='lili'
let zoo={cat,dog}
console.log(zoo)

let dog={type:'animal',many;2}
let{type,many}=dog
console.log(type,many)

/*
 * default,rest
 */
function animal(type='cat'){
	console.log(type)
}
animal()

function animal(...types){
	console.log(types)
}
animals('cat','dog','fish')