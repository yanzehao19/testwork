/**
 * 
 */
var person={
		firstName:"John",
		lastName:"Doe",
		age:50,
		eyeColor:"blue"
};

var person=new Object();
person.firstName="John";
perosn.lastName="Doe";
person.age=50;
person.eyeColor="blue";

function person(firstname,lastname,age.eyeColor){
	this.firstname=firstname;
	this.lastname=lastname;
	this.age=age;
	this.eyeColor=eyeColor;
	this.changeName=changeName;
	function changeName(name){
		this.lastname=name;
	}
}
var myFather=new person("John","Doe",50,"blue");

var person={fname:"John",lname:"Doe",age:25};
for(x in person){
	txt=txt+person[x];
}

var mycars=new Array();
mycars[0]="saab";
mycars[1]="volvo";
mycars[2]="bmw";

