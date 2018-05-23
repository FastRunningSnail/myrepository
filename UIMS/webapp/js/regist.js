/**
 * 
 */
function regist(){
	var loginname =document.getElementsByTagName('input')[0].value;
	if (loginname ==null || loginname == ''|| loginname == undefined) {
		alert('请输入用户名...');
		return false;
	}
	var password =document.getElementsByTagName('input')[1].value;
	if (password ==null || password == ''|| password == undefined) {
		alert('请输入密码...');
		return false;
	}
	var repass =document.getElementsByTagName('input')[2].value;
	if (repass!=password) {
		alert('两次密码输入不一致...');
		return false;
	}
}