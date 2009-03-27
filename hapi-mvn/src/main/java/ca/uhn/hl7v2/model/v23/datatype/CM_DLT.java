package ca.uhn.hl7v2.model.v23.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 CM_DLT (delta check) data type.  Consists of the following components: </p><ol>
 * <li>Range (CM_RANGE)</li>
 * <li>numeric threshold (NM)</li>
 * <li>change (ST)</li>
 * <li>length of time-days (NM)</li>
 * </ol>
 */
public class CM_DLT extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a CM_DLT.
	 * @param message the Message to which this Type belongs
	 */
	public CM_DLT(Message message) {
		super(message);
		data = new Type[4];
		data[0] = new CM_RANGE(message);
		data[1] = new NM(message);
		data[2] = new ST(message);
		data[3] = new NM(message);
	}

	/**
	 * Returns an array containing the data elements.
	 */
	public Type[] getComponents() { 
		return this.data; 
	}

	/**
	 * Returns an individual data component.
	 * @throws DataTypeException if the given element number is out of range.
	 */
	public Type getComponent(int number) throws DataTypeException { 

		try { 
			return this.data[number]; 
		} catch (ArrayIndexOutOfBoundsException e) { 
			throw new DataTypeException("Element " + number + " doesn't exist in 4 element CM_DLT composite"); 
		} 
	} 
	/**
	 * Returns Range (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CM_RANGE getRange() {
	   CM_RANGE ret = null;
	   try {
	      ret = (CM_RANGE)getComponent(0);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns numeric threshold (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getNumericThreshold() {
	   NM ret = null;
	   try {
	      ret = (NM)getComponent(1);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns change (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getChange() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(2);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns length of time-days (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getLengthOfTimeDays() {
	   NM ret = null;
	   try {
	      ret = (NM)getComponent(3);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}