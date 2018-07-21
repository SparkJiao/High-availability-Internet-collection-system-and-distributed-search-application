window.onload = function(){
	var website_name = $("#website_name");
    var channel_name = $("#channel_name");
    var channel_url = $("#channel_url");
    var start_time = $("#start_time");
    var stop_time = $("#stop_time");

    function addPattern(){
        $.ajax({
			type: "POST",
            url: "/",
            data:{website_name:website_name,channel_name:channel_name,channel_url:channel_url,start_time:start_time,stop_time:stop_time},
            datatype:"json",
			async:false,
			success:function(bloglist){

			}
		})
    }
}