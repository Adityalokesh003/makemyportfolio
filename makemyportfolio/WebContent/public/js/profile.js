/*$("input[name='dev_cat_update']").on("click",function(e) {
	let value = $("input[name='category_title']").val();
	e.preventDefault();
	$.ajax(
			{
				url: "/makemyportfolio/profile/edit",
				data: {
					name: 
					 value
					 
				},
				type: 'post',
				cache: false,
				success: function(data) {
					alert("success ");
				},
				error : function() {
					alert("failed");
				}

			}
	);
});*/