package socialcode.ideone.api.service;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javax.xml.rpc.ServiceException;

public class Ideone {

	final String username = "mohamedahmedkamal";
	final String password = "123456";
	HashMap<Integer, String> langs = new HashMap<Integer, String>();
	protected ArrayList<String> langsList = new ArrayList<String>();

	Ideone_Service_v1ServiceLocator locator;
	Ideone_Service_v1Port service;

	public Ideone() {
		langs.put(1, "C++");
		langs.put(2, "Pascal (gpc)");
		langs.put(3, "Perl");
		langs.put(4, "Python");
		langs.put(5, "Fortran");
		langs.put(6, "Whitespace");
		langs.put(7, "Ada");
		langs.put(8, "Ocaml");
		langs.put(9, "Intercal");
		langs.put(10, "Java");
		langs.put(11, "C");
		langs.put(12, "Brainf**k");
		langs.put(13, "Assembler");
		langs.put(14, "CLIPS");
		langs.put(15, "Prolog (swi)");
		langs.put(16, "Icon");
		langs.put(17, "Ruby");
		langs.put(19, "Pike");
		langs.put(21, "Haskell");
		langs.put(22, "Pascal (fpc)");
		langs.put(23, "Smalltalk");
		langs.put(25, "Nice");
		langs.put(26, "Lua");
		langs.put(27, "C#");
		langs.put(28, "Bash");
		langs.put(29, "PHP");
		langs.put(30, "Nemerle");
		langs.put(32, "Common Lisp (clisp)");
		langs.put(33, "Scheme (guile)");
		langs.put(34, "C99 strict");
		langs.put(35, "JavaScript (rhino)");
		langs.put(36, "Erlang");
		langs.put(38, "Tcl");
		langs.put(39, "Scala");
		langs.put(40, "SQL");
		langs.put(43, "Objective-C");
		langs.put(44, "C++0x");
		langs.put(45, "Assembler");
		langs.put(54, "Perl 6");
		langs.put(101, "Visual Basic .NET");
		langs.put(102, "D (dmd)");
		langs.put(104, "AWK (gawk)");
		langs.put(105, "AWK (mawk)");
		langs.put(106, "COBOL 85");
		langs.put(107, "Forth");
		langs.put(108, "Prolog (gnu)");
		langs.put(110, "bc");
		langs.put(111, "Clojure");
		langs.put(112, "JavaScript (spidermonkey)");
		langs.put(114, "Go");
		langs.put(115, "Unlambda");
		langs.put(116, "Python 3");
		langs.put(117, "R");
		langs.put(118, "COBOL");
		langs.put(119, "Oz");
		langs.put(121, "Groovy");
		langs.put(122, "Nimrod");
		langs.put(123, "Factor");
		langs.put(124, "F#");
		langs.put(125, "Falcon");
		for (Integer key : langs.keySet()) {
			this.langsList.add(langs.get(key));
		}
		Collections.sort(this.langsList);
		locator = new Ideone_Service_v1ServiceLocator();
		try {
			service = locator.getIdeone_Service_v1Port();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String createSubmission(String sourceCode, Integer language,
			String input, Boolean run, Boolean priv) throws Exception {

		Object sub[] = service.createSubmission(username, password, sourceCode,
				language, input, run, priv);
		HashMap<String, String> data = (HashMap) sub[0];
		String error = (String) data.get("error");
		if (error.equals("AUTH_ERROR")) {
			System.err.println("AUTH_ERROR");
		} else if (!error.equals("OK")) {
			System.err.println("AUTH_ERROR");
		}
		return (String) data.get("link");
	}

	public IdeoneSubmissionStatus getSubmissionStatus(String link)
			throws RemoteException {
		Object sub[] = service.getSubmissionStatus(username, password, link);
		HashMap<String, Object> data = (HashMap) sub[0];
		IdeoneSubmissionStatus ret = new IdeoneSubmissionStatus();
		ret.result = (Integer) data.get("result");
		ret.status = (Integer) data.get("status");
		return ret;
	}

	public IdeoneSubmissionDetails getSubmissionDetails(String link,
			Boolean withSource, Boolean withInput, Boolean withOutput,
			Boolean withStderr, Boolean withCmpinfo) throws RemoteException {
		Object sub[] = service.getSubmissionDetails(username, password, link,
				withSource, withInput, withOutput, withStderr, withCmpinfo);
		HashMap<String, Object> data = (HashMap) sub[0];
		IdeoneSubmissionDetails ret = new IdeoneSubmissionDetails();
		ret.langId = (Integer) data.get("result");
		ret.langName = (String) data.get("langName");
		ret.langVersion = (String) data.get("langVersion");
		ret.date = (String) data.get("date");
		// ret.time = (Float) data.get("time"); // no support for Float on ME
		// kSoap
		ret.time = Float.valueOf(( data.get("time")).toString());
		ret.result = (Integer) data.get("result");
		ret.status = (Integer) data.get("status");
		ret.memory = (Integer) data.get("memory");
		ret.signal = (Integer) data.get("signal");
		ret.isPublic = (Boolean) data.get("public");

		if (withSource.booleanValue()) {
			ret.source = (String) data.get("source");
		}
		if (withInput.booleanValue()) {
			ret.input = (String) data.get("input");
		}
		if (withOutput.booleanValue()) {
			ret.output = (String) data.get("output");
		}
		if (withStderr.booleanValue()) {
			ret.stderr = (String) data.get("stderr");
		}
		if (withCmpinfo.booleanValue()) {
			ret.cmpinfo = (String) data.get("cmpinfo");
		}
		return ret;
	}

	public static String translateStatus(int status) {
		if (status < 0) {
			return "waiting for compilation";
		} else if (status == 0) {
			return "done";
		} else if (status == 1) {
			return "compilation";
		} else if (status == 3) {
			return "running";
		}
		return "unknown status";
	}

	public static String translateState(int state) {
		if (state < 0) {
			return "waiting for compilation";
		}
		if (state == 0) {
			return "done";
		}
		if (state == 1) {
			return "compilation";
		}
		return "running";
	}

	public static String translateResult(int result) {
		switch (result) {
		case 0:
			return "not running";
		case 11:
			return "compilation error";
		case 12:
			return "runtime error";
		case 13:
			return "time limit exceeded";
		case 15:
			return "success";
		case 17:
			return "memory limit exceeded";
		case 19:
			return "illegal system call";
		case 20:
			return "internal error";
		}
		return "unknown result";
	}

	public ArrayList<String> getLangs() {
		return this.langsList;
	}

	public Integer getLanguageIdByName(String name) {
		for (Integer key : langs.keySet()) {
			if (langs.get(key).equals(name)) {
				return key;
			}
		}
		return 1;
	}
}
