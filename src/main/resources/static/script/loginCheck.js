/**
 * 회원 정보의 검증
 */

// true, false만 나오는 함수  --> 제한조건에 걸리지 않는 것들 한 번 더 거르기 위해서 자바스크립트 사용
function validation() {
	let blogid = document.getElementById("blogid");  // input 태그 안의 것들 전부 가져옴
	let blogpwd = document.getElementById("blogpwd");  // input 태그 안의 것들 전부 가져옴

	if (blogid.value.trim().length == 0) {
		alert("ID를 입력하세요");
		blogid.focus();
		blogid.select();
		return false;
	}
	
	if (blogpwd.value.trim().length == 0) {
		alert("비밀번호를 입력하세요.");
		blogpwd.focus();
		blogpwd.select();
		return false;
	}
	
	return true;  // 데이터 넘기기
}