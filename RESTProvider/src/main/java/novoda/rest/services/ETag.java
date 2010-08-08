
package novoda.rest.services;

import android.os.Parcel;
import android.os.Parcelable;

public class ETag implements Parcelable {
    
    static final String IF_NONE_MATCH = "If-None-Match";

    static final String IF_MODIFIED_SINCE = "If-Modified-Since";

    static final String ETAG = "ETag";

    static final String LAST_MODIFIED = "Last-Modified";

    public String etag;

    public String lastModified;

    private ETag(Parcel parcel) {
        etag = parcel.readString();
        lastModified = parcel.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int parcelableFlags) {
        parcel.writeString(etag);
        parcel.writeString(lastModified);
    }

    public static final Parcelable.Creator<ETag> CREATOR = new Parcelable.Creator<ETag>() {
        @Override
        public ETag createFromParcel(Parcel parcel) {
            return new ETag(parcel);
        }

        @Override
        public ETag[] newArray(int size) {
            return new ETag[size];
        }
    };
}