function validation() {
	if(confirm("삭제하시겠습니까?")) {
		return true;
	}
	return false;
}



$(function() {
   $("#likebutton").on('click', function() {
      let blogseq = $(this).attr("data-blogseq");
      
      $.ajax({
         method:"GET"
         , url:"/blog/blog/likecnt"
         , data:{"blogseq":blogseq}
         , dataType:"text"
         , success: function(resp) {
            $("#likecnt").text(resp);
         }
         , error:function(resp){
                alert(console.log(resp));} 
      }) 
      
   })
})