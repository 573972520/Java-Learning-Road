/**
 * 
 */


//url��������ĵ�ַ
//successFunc����һ�����󷵻سɹ�֮���һ��function����һ���������������Ƿ��������صı�����
function rpajax(url,successFunc)
{
	var xhr = window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject('Microsoft.XMLHTTP');//����XMLHTTP���󣬿��Ǽ�����
	xhr.open("POST",url,true);
	xhr.onreadystatechange = function()
	{
		if(xhr.readyState==4) //������������
		{
			if(xhr.status==200) //�õ�xhr.status http״̬��
			{
				successFunc(xhr.responseText);
			}
			else
			{
				alert("���������ش���");
			}
		}
	};
	xhr.send(); //�������󣬲�����ȷ���������send�����Ž��������������Ҫ��ǰ����xhr.onreadystatechange�¼����Ա��֪�������������ˡ�


}
