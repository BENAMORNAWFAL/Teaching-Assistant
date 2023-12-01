var msg=document.querySelector("#changing")
console.log("*********",msg)
function change(){
    
    msg.innerText="Todd E"
    console.log("*********",msg)
}

var rem=document.querySelector("#todd")
var rem1=document.querySelector("#phil")
var count=500
var count1=2

function increases(){
    count1--
    count++
    c1.innerText=count1
    c2.innerText=count
    remove()
}
function increases1(){
    count1--
    count++
    c1.innerText=count1
    c2.innerText=count
}

function remove(){
    rem.remove()
    c1.innerText=count1-1
    
    
}
function remove1(){
    rem1.remove()
    c1.innerText--
    increases1()
}

var c1=document.querySelector("#c2")
var c2=document.querySelector("#incr")