/**
 * 회원 정보의 검증
 */

// true, false만 나오는 함수  --> 제한조건에 걸리지 않는 것들 한 번 더 거르기 위해서 자바스크립트 사용
function validation() {
	let blogid = document.getElementById("blogid");  // input 태그 안의 것들 전부 가져옴
	let blogpwd = document.getElementById("blogpwd");  // input 태그 안의 것들 전부 가져옴
	let blogername = document.getElementById("blogername");  // input 태그 안의 것들 전부 가져옴

	if (blogid.value.trim().length < 3 || blogid.value.trim().length > 10) {
		alert("ID는 3~10자 사이로 입력하세요.");
		blogid.focus();
		blogid.select();
		return false;
	}
	
	if (blogpwd.value.trim().length < 3 || blogpwd.value.trim().length > 10) {
		alert("비밀번호는 3~10자 사이로 입력하세요.");
		blogpwd.focus();
		blogpwd.select();
		return false;
	}

	if (blogername.value.trim().length == 0) {
		alert("이름을 정확하게 입력하세요.");
		blogername.focus();
		blogername.select();
		return false;
	}	
	
	
	return true;  // 데이터 넘기기
}