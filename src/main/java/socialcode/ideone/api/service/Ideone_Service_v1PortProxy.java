package socialcode.ideone.api.service;

public class Ideone_Service_v1PortProxy implements
		socialcode.ideone.api.service.Ideone_Service_v1Port {
	private String _endpoint = null;
	private socialcode.ideone.api.service.Ideone_Service_v1Port ideone_Service_v1Port = null;

	public Ideone_Service_v1PortProxy() {
		_initIdeone_Service_v1PortProxy();
	}

	public Ideone_Service_v1PortProxy(String endpoint) {
		_endpoint = endpoint;
		_initIdeone_Service_v1PortProxy();
	}

	private void _initIdeone_Service_v1PortProxy() {
		try {
			ideone_Service_v1Port = (new socialcode.ideone.api.service.Ideone_Service_v1ServiceLocator())
					.getIdeone_Service_v1Port();
			if (ideone_Service_v1Port != null) {
				if (_endpoint != null)
					((javax.xml.rpc.Stub) ideone_Service_v1Port)
							._setProperty(
									"javax.xml.rpc.service.endpoint.address",
									_endpoint);
				else
					_endpoint = (String) ((javax.xml.rpc.Stub) ideone_Service_v1Port)
							._getProperty("javax.xml.rpc.service.endpoint.address");
			}

		} catch (javax.xml.rpc.ServiceException serviceException) {
		}
	}

	public String getEndpoint() {
		return _endpoint;
	}

	public void setEndpoint(String endpoint) {
		_endpoint = endpoint;
		if (ideone_Service_v1Port != null)
			((javax.xml.rpc.Stub) ideone_Service_v1Port)._setProperty(
					"javax.xml.rpc.service.endpoint.address", _endpoint);

	}

	public socialcode.ideone.api.service.Ideone_Service_v1Port getIdeone_Service_v1Port() {
		if (ideone_Service_v1Port == null)
			_initIdeone_Service_v1PortProxy();
		return ideone_Service_v1Port;
	}

	public java.lang.Object[] createSubmission(java.lang.String user,
			java.lang.String pass, java.lang.String sourceCode, int language,
			java.lang.String input, boolean run, boolean _private)
			throws java.rmi.RemoteException {
		if (ideone_Service_v1Port == null)
			_initIdeone_Service_v1PortProxy();
		return ideone_Service_v1Port.createSubmission(user, pass, sourceCode,
				language, input, run, _private);
	}

	public java.lang.Object[] getSubmissionStatus(java.lang.String user,
			java.lang.String pass, java.lang.String link)
			throws java.rmi.RemoteException {
		if (ideone_Service_v1Port == null)
			_initIdeone_Service_v1PortProxy();
		return ideone_Service_v1Port.getSubmissionStatus(user, pass, link);
	}

	public java.lang.Object[] getSubmissionDetails(java.lang.String user,
			java.lang.String pass, java.lang.String link, boolean withSource,
			boolean withInput, boolean withOutput, boolean withStderr,
			boolean withCmpinfo) throws java.rmi.RemoteException {
		if (ideone_Service_v1Port == null)
			_initIdeone_Service_v1PortProxy();
		return ideone_Service_v1Port.getSubmissionDetails(user, pass, link,
				withSource, withInput, withOutput, withStderr, withCmpinfo);
	}

	public java.lang.Object[] getLanguages(java.lang.String user,
			java.lang.String pass) throws java.rmi.RemoteException {
		if (ideone_Service_v1Port == null)
			_initIdeone_Service_v1PortProxy();
		return ideone_Service_v1Port.getLanguages(user, pass);
	}

	public java.lang.Object[] testFunction(java.lang.String user,
			java.lang.String pass) throws java.rmi.RemoteException {
		if (ideone_Service_v1Port == null)
			_initIdeone_Service_v1PortProxy();
		return ideone_Service_v1Port.testFunction(user, pass);
	}

}