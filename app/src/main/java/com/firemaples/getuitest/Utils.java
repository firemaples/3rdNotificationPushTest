package com.firemaples.getuitest;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import java.util.Arrays;

/**
 * Utils for base operation
 * Created by nester on 2016/4/13.
 */
public class Utils {
    private static final Logger logger = LoggerFactory.getLogger(Utils.class);

    public static String intentToString(Intent intent) {
        if (intent == null) {
            return null;
        }
        if (intent.getComponent().getClassName().equalsIgnoreCase("com.google.android.gms.ads.AdActivity")) {
            return null;
        } else {
            return intent.toString() + " " + bundleToString(intent.getExtras());
        }
    }

    public static String bundleToString(Bundle bundle) {
        StringBuilder out = new StringBuilder("Bundle[");

        if (bundle == null) {
            out.append("null");
        } else {
            try {
                boolean first = true;
                for (String key : bundle.keySet()) {
                    Object value = bundle.get(key);

                    try {
                        if (!first) {
                            out.append(", ");
                        }

                        out.append(key).append('=');

                        if (value instanceof int[]) {
                            out.append(Arrays.toString((int[]) value));
                        } else if (value instanceof byte[]) {
                            out.append(Arrays.toString((byte[]) value));
                        } else if (value instanceof boolean[]) {
                            out.append(Arrays.toString((boolean[]) value));
                        } else if (value instanceof short[]) {
                            out.append(Arrays.toString((short[]) value));
                        } else if (value instanceof long[]) {
                            out.append(Arrays.toString((long[]) value));
                        } else if (value instanceof float[]) {
                            out.append(Arrays.toString((float[]) value));
                        } else if (value instanceof double[]) {
                            out.append(Arrays.toString((double[]) value));
                        } else if (value instanceof String[]) {
                            out.append(Arrays.toString((String[]) value));
                        } else if (value instanceof CharSequence[]) {
                            out.append(Arrays.toString((CharSequence[]) value));
                        } else if (value instanceof Parcelable[]) {
                            out.append(Arrays.toString((Parcelable[]) value));
                        } else if (value instanceof Bundle) {
                            out.append(bundleToString((Bundle) value));
                        }
//                        else if (value instanceof NotifyData) {
//                            out.append(((NotifyData) value).toJson());
//                        }
                        else {
                            out.append(value);
                        }

                        first = false;
                    } catch (Throwable t) {
                        String typeName = null;
                        if (value != null) {
                            typeName = value.getClass().getCanonicalName();
                        }
                        logger.error("print object failed, object type: " + typeName, t);
                    }
                }
            } catch (Throwable t) {
                out.append("print bundle failed");
                logger.error("print bundle failed", t);
            }
        }

        out.append("]");
        return out.toString();
    }
}

