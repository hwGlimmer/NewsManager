//创建核心对象	
function Xhr() {
		var xhr = null;
		if (window.XMLHttpRequest) {
			xhr = new XMLHttpRequest;
		} else {
			//兼容IE6.0一下版本浏览器
			xhr = new ActiveXObject("Microsoft.XMLHttp");
		}
		return xhr;
	}