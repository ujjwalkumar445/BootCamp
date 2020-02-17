var employee = [
{'name': 'ujjwal', 'age' : '22','salary' :28000,'dob' : '10-03-1997'},
{'name': 'vibhav', 'age' : '26','salary' :37000,'dob' : '20-07-1993'},
{'name': 'aman', 'age' : '19','salary' :19000,'dob' : '28-09-2001'},
{'name': 'divyansh', 'age' : '40','salary' :4000,'dob' : '20-11-1979'},
{'name': 'vikas', 'age' : '32','salary' :10000,'dob' : '14-02-1987'},
{'name': 'vijay', 'age' : '38','salary' :89000,'dob' : '16-07-1981'},
{'name': 'nitin', 'age' : '56','salary' :120000,'dob' : '11-08-1963'}
]

//to fetch all object and their key,pairs
for(var i=0;i<employee.length;i++){
    for(k in employee[i]){
        console.log(`${k} : ${employee[i][k]}`);
    }
    console.log("\n");
}

// Filter employees based on salary
greaterSalary = [];
for(var i=0;i<employee.length;i++){
    if(employee[i]['salary']>5000){
        greaterSalary.push(employee[i]['name']);
    }
}
console.log(`\nPeople having higher salary than 5000 are: ${greaterSalary}`)

// Grouping employee on basis on their salary
groupEmps = {}
for(var i=0;i<employee.length;i++){
    console.log(employee[i]['age']);
    if(groupEmps.hasOwnProperty(employee[i]['age'])){
        groupEmps[employee[i]['age']].push(employee[i]);
    }
    else{
        groupEmps[employee[i]['age']] = [];
        groupEmps[employee[i]['age']].push(employee[i]);
    }
}
console.log(groupEmps);

// Fetching employees with age greater than 20 and salary less than 1000.
lowerSalaryAge = [];
for(var i=0;i<employee.length;i++){
    if(employee[i]['salary'] < 1000 && employee[i]['age'] > 20){
        lowerSalaryAge.push(employee[i]['name']);
        employee[i]['salary'] += 5 * employee[i]['salary']; 
    }
}
console.log(`\nPeople having lower salary than 1000 are: ${lowerSalaryAge}`);

for(var i=0;i<employee.length;i++){
    for(k in employee[i]){
        console.log(`${k} : ${employee[i][k]}`);
    }
    console.log("\n");
}