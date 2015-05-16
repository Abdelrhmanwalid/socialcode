package socialcode.ideone.api.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import socialcode.model.Code;
import socialcode.service.CodeService;

@Component
@Scope("prototype")
public class RunCodeThread implements Runnable {

	CodeService codeService;

	public CodeService getCodeService() {
		return codeService;
	}

	public void setCodeService(CodeService codeService) {
		this.codeService = codeService;
	}

	protected int mState;
	protected int status = 0;

	final static int STATE_DONE = 0;
	final static int STATE_RUNNING = 1;

	protected String source = "";
	protected String input = "";
	protected int lang = 1;

	protected Code code = null;

	public Code getCode() {
		return code;
	}

	public void setCode(Code code) {
		this.code = code;
	}

	public RunCodeThread() {
		// none
	}

	public void setLang(int lang) {
		this.lang = lang;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void run() {

		mState = STATE_RUNNING;
		handle("open", "");

		Ideone ideone = new Ideone();
		boolean priv = false;

		// create ideone link
		String link = null;
		try {
			link = ideone.createSubmission(source, lang, input, true, priv);
			if (link == null)
				throw new Exception("null");
			handle("echo", link);
		} catch (Exception e) {
			handle("error", "Error");
			return;
		}

		// wait
		while (mState == STATE_RUNNING) {

			// interrupt
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
            System.out.println("Running "+ code.getId());
            IdeoneSubmissionStatus iss = null;
			try {
				iss = ideone.getSubmissionStatus(link);
				code.setStatus("Running");
				if (iss == null) {
					handle("error", "Error #3");
					continue;
				}
				System.out.println(iss.status);
			} catch (Exception e) {
				handle("error", link);
			}
			status = iss.status;

			if (status == 0) {
				this.mState = STATE_DONE;
				code.setStatus("Done");
                //codeService.save(code);
                System.out.println("Done "+code.getStatus());
            }
			handle("echo", Ideone.translateState(status));
		}

		// get full info
		try {
			IdeoneSubmissionDetails isd = ideone.getSubmissionDetails(link,
					false, false, true, true, true);
			if (isd != null) {
				String out = isd.output;
				if (isd.cmpinfo != null && !isd.cmpinfo.equals("")) {
					out = isd.cmpinfo + "\n" + out;
				}
				if (isd.stderr != null && !isd.stderr.equals("")) {
					out = out + "\n---" + isd.stderr;
				}

				handle("echo", Ideone.translateResult(isd.result));
				handle("result", Ideone.translateResult(isd.result));
				handle("echo2", out);

				code.setOutput(out);
				codeService.update(code);
                System.out.println("Saved");
			}
		} catch (Exception e) {
			handle("error", "Auth error");
		}

		// hide dialog
		handle("close", "");
	}

	/**
	 * return data to main thread
	 * 
	 * @param command
	 * @param text
	 */
	protected void handle(String command, String text) {
		// System.out.println(command + " " + text);
		// Message msg = handler.obtainMessage();
		// Bundle b = new Bundle();
		// b.putString("command", command);
		// b.putString("text", text);
		// msg.setData(b);
		// handler.sendMessage(msg);
	}

	/*
	 * sets the current state for the thread, used to stop the thread
	 */
	public void setState(int state) {
		mState = state;
	}
}