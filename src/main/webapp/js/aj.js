$(function(){
	var today = new Date();
	var year = today.getFullYear();
	var month = today.getMonth() + 1 + "";
	if (month.length == 1) {
		month = "0" + month;
	}
	var date = today.getDate() + "";
	if (date.length == 1) {
		date = "0" + date;
	}
	var hour = today.getHours() + "";
	if (hour.length == 1) {
		hour = "0" + hour;
	}
	var min = today.getMinutes() + "";
	if (min.length == 1) {
		min = "0" + min;
	}
	time = year + "-" + month + "-" + date + "T" + hour + ":" + min;
	$("#date").val(time);
}); 