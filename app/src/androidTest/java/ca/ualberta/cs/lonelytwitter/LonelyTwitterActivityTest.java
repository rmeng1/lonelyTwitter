package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.ListView;

import com.robotium.solo.Solo;

import junit.framework.TestCase;

public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {
    private Solo solo;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    /**
     * Run at the beginning of the tests
     * @throws Exception
     */
    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();

    }

    public void testTweet() {

        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class);
        solo.enterText((EditText) solo.getView(R.id.body), "Test Tweet!");
        solo.clickOnButton("Save");
        solo.enterText((EditText) solo.getView(R.id.body), "");

        assertTrue(solo.waitForText("Test Tweet!"));

        solo.clickOnButton("Clear");

    }

    public void testClickTweetList() {
        solo.assertCurrentActivity("Wrong activity", LonelyTwitterActivity.class);
        solo.clickOnButton("Clear");

        solo.enterText((EditText) solo.getView(R.id.body), "Test Tweet!");
        solo.clickOnButton("Save");
        solo.waitForText("Test Tweet!");    // wait for it appear in the list

        solo.clickInList(0);
        solo.assertCurrentActivity("Wrong activity", EditTweetActivity.class);

        assertTrue(solo.waitForText("Test Tweet!"));
        solo.goBack();
        solo.assertCurrentActivity("Wrong Activity!", LonelyTwitterActivity.class);
    }

    /**
     * Run at the end of the test
     * @throws Exception
     */
    public void testDown() throws Exception {
        solo.finishOpenedActivities();
    }
}
