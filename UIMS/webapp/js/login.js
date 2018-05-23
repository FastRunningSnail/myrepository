/**
 * 
 */
function login(){
	var loginname =document.getElementsByTagName('input')[0].value;
	if (loginname ==null || loginname == ''|| loginname == undefined) {
		alert('请输入用户名...');
		return false;
	}
	var loginname =document.getElementsByTagName('input')[1].value;
	if (password ==null || password == ''|| password == undefined) {
		alert('请输入密码...');
		return false;
	}
}