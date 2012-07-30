package ca.uhn.hl7v2.hoh;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum ResponseCode {

	HTTP_200_OK(200, "OK"),

	HTTP_400_BAD_REQUEST(400, "Bad Request"),

	HTTP_500_INTERNAL_SERVER_ERROR(500, "Internal Server Error"), ;

	private int myCode;
	private String myMessage;
	private static final Map<String, ResponseCode> ourAckCodesToResponseCodes = new HashMap<String, ResponseCode>();
	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(ResponseCode.class);

	static {
		ourAckCodesToResponseCodes.put("AA", HTTP_200_OK);
		ourAckCodesToResponseCodes.put("CA", HTTP_200_OK);
		ourAckCodesToResponseCodes.put("AR", HTTP_400_BAD_REQUEST);
		ourAckCodesToResponseCodes.put("CR", HTTP_400_BAD_REQUEST);
		ourAckCodesToResponseCodes.put("AE", HTTP_500_INTERNAL_SERVER_ERROR);
		ourAckCodesToResponseCodes.put("CE", HTTP_500_INTERNAL_SERVER_ERROR);
	}

	ResponseCode(int theCode, String theMessage) {
		myCode = theCode;
		myMessage = theMessage;
	}

	/**
	 * Returns the appropriate response code for a given ACK code. If none can
	 * be detected, returns {@link #HTTP_500_INTERNAL_SERVER_ERROR}
	 * 
	 * @param theAcknowledgementCode
	 *            The acknowledgement code, e.g. "AA", or "CE"
	 * @return The appropriate code
	 */
	public static ResponseCode forAcknowledgementCode(String theAcknowledgementCode) {
		ResponseCode retVal = null;
		if (theAcknowledgementCode != null) {
			retVal = ourAckCodesToResponseCodes.get(theAcknowledgementCode);
		} else {
			ourLog.warn("No HTTP response code defined for acknowledgement code: " + theAcknowledgementCode);
			retVal = ResponseCode.HTTP_500_INTERNAL_SERVER_ERROR;
		}
		if (retVal == null) {
			ourLog.warn("No HTTP response code defined for acknowledgement code: " + theAcknowledgementCode);
			retVal = HTTP_500_INTERNAL_SERVER_ERROR;
		}
		return retVal;
	}

	/**
	 * Detects the appropriate HTTP response code for a given message
	 * 
	 * @param theMessage
	 * @return
	 */
	public static ResponseCode detect(String theMessage) {
		switch (EncodingStyle.detect(theMessage)) {
		case ER7:
		default:
			StringTokenizer tok = new StringTokenizer(theMessage, "\r");
			while (tok.hasMoreTokens()) {
				String nextSegment = tok.nextToken();
				if (nextSegment.startsWith("MSA")) {
					if (nextSegment.length() >= 6) {
						String code = nextSegment.substring(4, 6);
						return forAcknowledgementCode(code);
					}
				}
			}
			ourLog.warn("Could not detect MSA.1 value in ER7 message");
			return HTTP_500_INTERNAL_SERVER_ERROR;

		case XML:

			Pattern p = Pattern.compile("<MSA\\.1>(.*?)</MSA\\.1>");
			Matcher m = p.matcher(theMessage);
			if (m.find()) {
				String code = m.group(1);
				return forAcknowledgementCode(code);
			} else {
				ourLog.warn("Could not detect MSA.1 value in XML message");
				return ResponseCode.HTTP_500_INTERNAL_SERVER_ERROR;
			}
		}
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return myCode;
	}

	/**
	 * @param theCode
	 *            the code to set
	 */
	public void setCode(int theCode) {
		myCode = theCode;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return myMessage;
	}

	/**
	 * @param theMessage
	 *            the message to set
	 */
	public void setMessage(String theMessage) {
		myMessage = theMessage;
	}

}
