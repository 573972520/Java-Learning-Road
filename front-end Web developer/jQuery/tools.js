/*
此js文件中包含常用的js函数
1 getDateString(date)  以yyyy-MM-dd hh:mm:ss的格式获取时间字符串
2 checkPasswordLevel(value) 检查密码强度等级
 */

function getDateString(date){
    var str="";

    //添加年时间分量
    str+=date.getFullYear();
    str+="-";

    //添加月份时间分量
    var month = date.getMonth()+1;
    if(month<10){
        str+="0";
    }
    str+=month;
    str+="-";

    //添加月中的日期时间分量
    var day = date.getDate();
    if(day<10){
        str+="0";
    }
    str+=day;
    str+=" ";

    //添加小时时间分量
    var hour = date.getHours();
    if(hour<10){
        str+="0";
    }
    str+=hour;
    str+=":";

    //添加分钟时间分量
    var minute = date.getMinutes();
    if(minute<10){
        str+="0";
    }
    str+=minute;
    str+=":";

    //添加秒时间分量
    var second = date.getSeconds();
    if(second<10){
        str+="0";
    }
    str+=second;

    return str;
}

/*
检查密码强度，
如果密码长度小于6，强度等级为1，表示弱，
如果密码长度大于等于8，且包含数字、小写字母和大写字母，强度等级为3，表示强
其余情况强度等级为2，表示中等强度
 */
function checkPasswordLevel(value){
    if(!value){
        return 1;
    }
    if(value.length<6){
        return 1;
    }
    if(value.length>=8 && /[0-9]/.test(value) && /[a-z]/.test(value) && /[A-Z]/.test(value) ){
        return 3;
    }
    return 2;
}

/*
检查值是否是邮箱格式
 */
function checkMail(value){
    return /^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/.test(value);
}

/*
检查年龄是否在[0-150]
 */
function checkAge(value){
    if(value){
        value = parseInt(value);
        if(value>=0 && value<=150){
            return true;
        }
    }
    return false;
}