//�������Ķ���	
function Xhr() {
		var xhr = null;
		if (window.XMLHttpRequest) {
			xhr = new XMLHttpRequest;
		} else {
			//����IE6.0һ�°汾�����
			xhr = new ActiveXObject("Microsoft.XMLHttp");
		}
		return xhr;
	}