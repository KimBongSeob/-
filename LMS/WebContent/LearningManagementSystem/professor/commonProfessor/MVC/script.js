function test(ul){
	var id = document.getElementbyid("test");
	for(var i=0; i<id.size;i++){
		if(id.li[i]==="active"){
			
		}
	}
}

function writeSave() {

	if (document.writeform.subject.value == "") {
		alert("제목을 입력하십시요.");
		document.writeform.subject.focus();
		return false;
	}

	if (document.writeform.content.value == "") {
		alert("내용을 입력하십시요.");
		document.writeform.content.focus();
		return false;
	}

	if (document.writeform.passwd.value == "") {
		alert("비밀번호를 입력하십시요.");
		document.writeform.passwd.focus();
		return false;
	}
}