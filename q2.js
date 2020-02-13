var str1 = prompt("Enter a string to check palindrome")

function palindrome(str1){
    var flag = 1;

    for(var i=0;i<=str1.length/2;i++){
        if(str1[i] != str1[str1.length - i -1]){
            flag = 0;
        }

}
return flag;
}

flag = palindrome(str1)
if(flag==1){
    alert("The string is Palindrome!")
}
else{
    alert("String is not palindrome!")
}