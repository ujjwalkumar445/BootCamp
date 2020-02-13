function areaOfCircle(radius){
    const pi = 3.14;
    var area;
    area = pi * radius * radius;
return area;
}

var r = prompt('Enter the radius of the circle');
alert(`The area is ${areaOfCircle(r)}`);