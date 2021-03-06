package org.mozilla.webmaker.util;

import com.google.android.gms.analytics.HitBuilders;
import android.app.Activity;
import android.content.Intent;
import org.mozilla.webmaker.R;
import org.mozilla.webmaker.WebmakerApplication;

public class Share {

    /**
     * Launches a share intent.
     *
     * @param url URL to be appended to the share body
     * @param activity Base activity
     */
    public static void launchShareIntent(final String userId, final String id, final Activity activity) {
        WebmakerApplication.getTracker().send(new HitBuilders.EventBuilder()
            .setCategory("Share").setAction("Share Intent").setLabel("Send Share Intent to OS").build());

        final Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
        final String shareSubject = activity.getString(R.string.share_subject);
        final String url = activity.getString(R.string.share_url) + "/users/" + userId + "/projects/" + id;
        final String shareBody = activity.getString(R.string.share_body).concat(" " + url);

        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody);

        activity.startActivity(Intent.createChooser(shareIntent, "Share"));
    }
}
