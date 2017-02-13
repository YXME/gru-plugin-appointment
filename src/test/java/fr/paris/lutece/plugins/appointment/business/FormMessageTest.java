package fr.paris.lutece.plugins.appointment.business;

import fr.paris.lutece.plugins.appointment.business.form.Form;
import fr.paris.lutece.plugins.appointment.business.form.FormHome;
import fr.paris.lutece.plugins.appointment.business.message.FormMessage;
import fr.paris.lutece.plugins.appointment.business.message.FormMessageHome;
import fr.paris.lutece.test.LuteceTestCase;

/**
 * Test Class for the FormMessage
 * 
 * @author Laurent Payen
 *
 */
public class FormMessageTest extends LuteceTestCase {

	public static final String CALENDAR_TITLE_1 = "CalendarTitle1";
	public static final String CALENDAR_TITLE_2 = "CalendarTitle2";
	public static final String FIELD_FIRSTNAME_TITLE_1 = "FieldFirstNameTitle1";
	public static final String FIELD_FIRSTNAME_TITLE_2 = "FieldFirstNameTitle2";
	public static final String FIELD_FIRSTNAME_HELP_1 = "FieldFirstNameHelp1";
	public static final String FIELD_FIRSTNAME_HELP_2 = "FieldFirstNameHelp2";
	public static final String FIELD_LASTNAME_TITLE_1 = "FieldLastNameTitle1";
	public static final String FIELD_LASTNAME_TITLE_2 = "FieldLastNameTitle2";
	public static final String FIELD_LASTNAME_HELP_1 = "FieldLastNameHelp1";
	public static final String FIELD_LASTNAME_HELP_2 = "FieldLastNameHelp2";
	public static final String FIELD_EMAIL_TITLE_1 = "FieldEmailTitle1";
	public static final String FIELD_EMAIL_TITLE_2 = "FieldEmailTitle2";
	public static final String FIELD_EMAIL_HELP_1 = "FieldEmailHelp1";
	public static final String FIELD_EMAIL_HELP_2 = "FieldEmailHelp2";
	public static final String FIELD_CONFIRMATION_EMAIL_TITLE_1 = "FieldConfirmationEmailTitle1";
	public static final String FIELD_CONFIRMATION_EMAIL_TITLE_2 = "FieldCOnfirmationEmailTitle2";
	public static final String FIELD_CONFIRMATION_EMAIL_HELP_1 = "FieldConfirmationEmailHelp1";
	public static final String FIELD_CONFIRMATION_EMAIL_HELP_2 = "FieldCOnfirmationEmailHelp2";
	public static final String TEXT_APPOINTMENT_CREATED_1 = "TextAppointmentCreated1";
	public static final String TEXT_APPOINTMENT_CREATED_2 = "TextAppointmentCreated2";
	public static final String URL_REDIRECT_AFTER_CREATION_1 = "UrlRedirectAfterCreation1";
	public static final String URL_REDIRECT_AFTER_CREATION_2 = "UrlRedirectAfterCreation2";
	public static final String TEXT_APPOINTMENT_CANCELED_1 = "TextAppointmentCanceled1";
	public static final String TEXT_APPOINTMENT_CANCELED_2 = "TextAppointmentCanceled2";
	public static final String LABEL_BUTTON_REDIRECTION_1 = "LabelButtonRedirection1";
	public static final String LABEL_BUTTON_REDIRECTION_2 = "LabelButtonRedirection2";
	public static final String NO_AVAILABLE_SLOT_1 = "NoAvailableSLot1";
	public static final String NO_AVAILABLE_SLOT_2 = "NoAvailableSLot2";
	public static final String CALENDAR_DESCRIPTION_1 = "CalendarDescription1";
	public static final String CALENDAR_DESCRIPTION_2 = "CalendarDescription2";
	public static final String CALENDAR_RESERVE_LABEL_1 = "CalendarReserveLabel1";
	public static final String CALENDAR_RESERVE_LABEL_2 = "CalendarReserveLabel2";
	public static final String CALENDAR_FULL_LABEL_1 = "CalendarFullLabel1";
	public static final String CALENDAR_FULL_LABEL_2 = "CalendarFullLabel2";

	/**
	 * Test method for the FormMessage (CRUD)
	 */
	public void testFormMessage() {
		Form form = FormTest.buildForm();
		FormHome.create(form);

		// Initialize a FormMessage
		FormMessage formMessage = buildFormMessage();
		formMessage.setIdForm(form.getIdForm());
		// Create the FormMessage in database
		FormMessageHome.create(formMessage);
		// Find the FormMessage created in database
		FormMessage formMessageStored = FormMessageHome.findByPrimaryKey(formMessage.getIdFormMessage());
		// Check Asserts
		checkAsserts(formMessageStored, formMessage);

		// Update the FormMessage
		formMessage.setCalendarTitle(CALENDAR_TITLE_2);
		formMessage.setFieldFirstNameTitle(FIELD_FIRSTNAME_TITLE_2);
		formMessage.setFieldFirstNameHelp(FIELD_FIRSTNAME_HELP_2);
		formMessage.setFieldLastNameTitle(FIELD_LASTNAME_TITLE_2);
		formMessage.setFieldLastNameHelp(FIELD_LASTNAME_HELP_2);
		formMessage.setFieldEmailTitle(FIELD_EMAIL_TITLE_2);
		formMessage.setFieldEmailHelp(FIELD_EMAIL_HELP_2);
		formMessage.setFieldConfirmationEmail(FIELD_CONFIRMATION_EMAIL_TITLE_2);
		formMessage.setFieldConfirmationEmailHelp(FIELD_CONFIRMATION_EMAIL_HELP_2);
		formMessage.setTextAppointmentCreated(TEXT_APPOINTMENT_CREATED_2);
		formMessage.setUrlRedirectAfterCreation(URL_REDIRECT_AFTER_CREATION_2);
		formMessage.setTextAppointmentCanceled(TEXT_APPOINTMENT_CANCELED_2);
		formMessage.setLabelButtonRedirection(LABEL_BUTTON_REDIRECTION_2);
		formMessage.setNoAvailableSlot(NO_AVAILABLE_SLOT_2);
		formMessage.setCalendarDescription(CALENDAR_DESCRIPTION_2);
		formMessage.setCalendarReserveLabel(CALENDAR_RESERVE_LABEL_2);
		formMessage.setCalendarFullLabel(CALENDAR_FULL_LABEL_2);
		// Update the FormMessage in database
		FormMessageHome.update(formMessage);
		// Find the FormMessage updated in database
		formMessageStored = FormMessageHome.findByPrimaryKey(formMessage.getIdFormMessage());
		// Check Asserts
		checkAsserts(formMessageStored, formMessage);

		// Delete the FormMessage
		FormMessageHome.delete(formMessage.getIdFormMessage());
		formMessageStored = FormMessageHome.findByPrimaryKey(formMessage.getIdFormMessage());
		// Check the FormMessage has been removed from database
		assertNull(formMessageStored);

		// Clean
		FormHome.delete(form.getIdForm());
	}

	/**
	 * Test delete cascade
	 */
	public void testDeleteCascade() {
		Form form = FormTest.buildForm();
		FormHome.create(form);

		// Initialize a FormMessage
		FormMessage formMessage = buildFormMessage();
		formMessage.setIdForm(form.getIdForm());
		// Create the FormMessage in database
		FormMessageHome.create(formMessage);
		// Find the FormMessage created in database
		FormMessage formMessageStored = FormMessageHome.findByPrimaryKey(formMessage.getIdFormMessage());
		assertNotNull(formMessageStored);
		// Delete the Form and by cascade the FormMessage
		FormHome.delete(form.getIdForm());
		formMessageStored = FormMessageHome.findByPrimaryKey(formMessage.getIdFormMessage());
		// Check the FormMessage has been removed from database
		assertNull(formMessageStored);

	}

	/**
	 * Test findByIdForm method
	 */
	public void testFindByIdForm() {
		Form form = FormTest.buildForm();
		FormHome.create(form);

		// Initialize a FormMessage
		FormMessage formMessage = buildFormMessage();
		formMessage.setIdForm(form.getIdForm());
		// Create the FormMessage in database
		FormMessageHome.create(formMessage);
		// Find the FormMessage created in database
		FormMessage formMessageStored = FormMessageHome.findByIdForm(form.getIdForm());
		// Check Asserts
		checkAsserts(formMessageStored, formMessage);

		// Clean
		FormHome.delete(form.getIdForm());
	}

	/**
	 * Build a FormMessage Business Object
	 * 
	 * @return the formMessage
	 */
	public FormMessage buildFormMessage() {
		FormMessage formMessage = new FormMessage();
		formMessage.setCalendarTitle(CALENDAR_TITLE_1);
		formMessage.setFieldFirstNameTitle(FIELD_FIRSTNAME_TITLE_1);
		formMessage.setFieldFirstNameHelp(FIELD_FIRSTNAME_HELP_1);
		formMessage.setFieldLastNameTitle(FIELD_LASTNAME_TITLE_1);
		formMessage.setFieldLastNameHelp(FIELD_LASTNAME_HELP_1);
		formMessage.setFieldEmailTitle(FIELD_EMAIL_TITLE_1);
		formMessage.setFieldEmailHelp(FIELD_EMAIL_HELP_1);
		formMessage.setFieldConfirmationEmail(FIELD_CONFIRMATION_EMAIL_TITLE_1);
		formMessage.setFieldConfirmationEmailHelp(FIELD_CONFIRMATION_EMAIL_HELP_1);
		formMessage.setTextAppointmentCreated(TEXT_APPOINTMENT_CREATED_1);
		formMessage.setUrlRedirectAfterCreation(URL_REDIRECT_AFTER_CREATION_1);
		formMessage.setTextAppointmentCanceled(TEXT_APPOINTMENT_CANCELED_1);
		formMessage.setLabelButtonRedirection(LABEL_BUTTON_REDIRECTION_1);
		formMessage.setNoAvailableSlot(NO_AVAILABLE_SLOT_1);
		formMessage.setCalendarDescription(CALENDAR_DESCRIPTION_1);
		formMessage.setCalendarReserveLabel(CALENDAR_RESERVE_LABEL_1);
		formMessage.setCalendarFullLabel(CALENDAR_FULL_LABEL_1);
		return formMessage;
	}

	/**
	 * Check that all the asserts are true
	 * 
	 * @param formMessageStored
	 *            the FormMessage stored
	 * @param formMessage
	 *            the FormMessage created
	 */
	public void checkAsserts(FormMessage formMessageStored, FormMessage formMessage) {
		assertEquals(formMessageStored.getCalendarTitle(), formMessage.getCalendarTitle());
		assertEquals(formMessageStored.getFieldFirstNameTitle(), formMessage.getFieldFirstNameTitle());
		assertEquals(formMessageStored.getFieldFirstNameHelp(), formMessage.getFieldFirstNameHelp());
		assertEquals(formMessageStored.getFieldLastNameTitle(), formMessage.getFieldLastNameTitle());
		assertEquals(formMessageStored.getFieldLastNameHelp(), formMessage.getFieldLastNameHelp());
		assertEquals(formMessageStored.getFieldEmailTitle(), formMessage.getFieldEmailTitle());
		assertEquals(formMessageStored.getFieldEmailHelp(), formMessage.getFieldEmailHelp());
		assertEquals(formMessageStored.getFieldConfirmationEmail(), formMessage.getFieldConfirmationEmail());
		assertEquals(formMessageStored.getFieldConfirmationEmailHelp(), formMessage.getFieldConfirmationEmailHelp());
		assertEquals(formMessageStored.getTextAppointmentCreated(), formMessage.getTextAppointmentCreated());
		assertEquals(formMessageStored.getUrlRedirectAfterCreation(), formMessage.getUrlRedirectAfterCreation());
		assertEquals(formMessageStored.getTextAppointmentCanceled(), formMessage.getTextAppointmentCanceled());
		assertEquals(formMessageStored.getLabelButtonRedirection(), formMessage.getLabelButtonRedirection());
		assertEquals(formMessageStored.getNoAvailableSlot(), formMessage.getNoAvailableSlot());
		assertEquals(formMessageStored.getCalendarDescription(), formMessage.getCalendarDescription());
		assertEquals(formMessageStored.getCalendarReserveLabel(), formMessage.getCalendarReserveLabel());
		assertEquals(formMessageStored.getCalendarFullLabel(), formMessage.getCalendarFullLabel());
		assertEquals(formMessageStored.getIdForm(), formMessage.getIdForm());
	}

}
