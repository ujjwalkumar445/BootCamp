var obj1 = {'name':'ujjwal','surname':'kumar','age':22,'github':'ujjwalkumar445'};
var obj2 = {}
var key;
// Method 1
// obj2 = {...obj2}

//Method 2
for(var k in obj1){
    obj2[k] = obj1[k];
}
console.log(Object.keys(obj2));
console.log(Object.values(obj2));