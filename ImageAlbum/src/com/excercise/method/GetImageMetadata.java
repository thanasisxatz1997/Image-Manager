package com.excercise.method;
import java.awt.image.ImagingOpException;
import java.io.File;
import java.io.IOException;
/*import java.util.List;
import org.*;

public class GetImageMetadata {
    public static String[] metadataExample(final File file) throws ImageReadException,IOException {
        // get all metadata stored in EXIF format (ie. from JPEG or TIFF).
        final IImageMetadata metadata =  Imaging.getMetadata(file);
        System.out.println(file.getPath());

        System.out.println(metadata);
        String[] Coordinates=new String[2];

        if (metadata instanceof JpegImageMetadata) {
            final JpegImageMetadata jpegMetadata = (JpegImageMetadata) metadata;

            // Jpeg EXIF metadata is stored in a TIFF-based directory structure
            // and is identified with TIFF tags.
            // Here we look for the "x resolution" tag, but
            // we could just as easily search for any other tag.
            //
            // see the TiffConstants file for a list of TIFF tags.

            System.out.println("file: " + file.getPath());

            // print out various interesting EXIF tags.
            printTagValue(jpegMetadata, TiffTagConstants.TIFF_TAG_XRESOLUTION);
            printTagValue(jpegMetadata, TiffTagConstants.TIFF_TAG_DATE_TIME);
            printTagValue(jpegMetadata,
                    ExifTagConstants.EXIF_TAG_DATE_TIME_ORIGINAL);
            //printTagValue(jpegMetadata, ExifTagConstants.EXIF_TAG_DATE_TIME_DIGITIZED);
            printTagValue(jpegMetadata, ExifTagConstants.EXIF_TAG_ISO);
            printTagValue(jpegMetadata,
                    ExifTagConstants.EXIF_TAG_SHUTTER_SPEED_VALUE);
            printTagValue(jpegMetadata,
                    ExifTagConstants.EXIF_TAG_APERTURE_VALUE);
            printTagValue(jpegMetadata,
                    ExifTagConstants.EXIF_TAG_BRIGHTNESS_VALUE);
            printTagValue(jpegMetadata,
                    GPSTagConstants.GPS_TAG_GPS_LATITUDE_REF);
            printTagValue(jpegMetadata, GPSTagConstants.GPS_TAG_GPS_LATITUDE);
            printTagValue(jpegMetadata,
                    GPSTagConstants.GPS_TAG_GPS_LONGITUDE_REF);
            printTagValue(jpegMetadata, GPSTagConstants.GPS_TAG_GPS_LONGITUDE);

            System.out.println();

            // simple interface to GPS data
            final TiffImageMetadata exifMetadata = jpegMetadata.getExif();
            if (null != exifMetadata) {
                final TiffImageMetadata.GPSInfo gpsInfo = exifMetadata.getGPS();
                if (null != gpsInfo) {
                    final String gpsDescription = gpsInfo.toString();
                    final double longitude = gpsInfo.getLongitudeAsDegreesEast();
                    final double latitude = gpsInfo.getLatitudeAsDegreesNorth();

                    System.out.println("    " + "GPS Description: "
                            + gpsDescription);
                    System.out.println("    "
                            + "GPS Longitude (Degrees East): " + longitude);
                    System.out.println("    "
                            + "GPS Latitude (Degrees North): " + latitude);
                }
            }

            // more specific example of how to manually access GPS values
            final TiffField gpsLatitudeRefField = jpegMetadata
                    .findEXIFValueWithExactMatch(GPSTagConstants.GPS_TAG_GPS_LATITUDE_REF);
            final TiffField gpsLatitudeField = jpegMetadata
                    .findEXIFValueWithExactMatch(GPSTagConstants.GPS_TAG_GPS_LATITUDE);
            final TiffField gpsLongitudeRefField = jpegMetadata
                    .findEXIFValueWithExactMatch(GPSTagConstants.GPS_TAG_GPS_LONGITUDE_REF);
            final TiffField gpsLongitudeField = jpegMetadata
                    .findEXIFValueWithExactMatch(GPSTagConstants.GPS_TAG_GPS_LONGITUDE);
            if (gpsLatitudeRefField != null && gpsLatitudeField != null
                    && gpsLongitudeRefField != null
                    && gpsLongitudeField != null) {
                // all of these values are strings.
                final String gpsLatitudeRef = (String) gpsLatitudeRefField.getValue();
                final RationalNumber gpsLatitude[] = (RationalNumber[]) (gpsLatitudeField
                        .getValue());
                final String gpsLongitudeRef = (String) gpsLongitudeRefField
                        .getValue();
                final RationalNumber gpsLongitude[] = (RationalNumber[]) gpsLongitudeField
                        .getValue();

                final RationalNumber gpsLatitudeDegrees = gpsLatitude[0];
                final RationalNumber gpsLatitudeMinutes = gpsLatitude[1];
                final RationalNumber gpsLatitudeSeconds = gpsLatitude[2];

                final RationalNumber gpsLongitudeDegrees = gpsLongitude[0];
                final RationalNumber gpsLongitudeMinutes = gpsLongitude[1];
                final RationalNumber gpsLongitudeSeconds = gpsLongitude[2];

                // This will format the gps info like so:
                //
                // gpsLatitude: 8 degrees, 40 minutes, 42.2 seconds S
                // gpsLongitude: 115 degrees, 26 minutes, 21.8 seconds E

                System.out.println("    " + "GPS Latitude: "
                        + gpsLatitudeDegrees.toDisplayString() + " degrees, "
                        + gpsLatitudeMinutes.toDisplayString() + " minutes, "
                        + gpsLatitudeSeconds.toDisplayString() + " seconds "
                        + gpsLatitudeRef);
                System.out.println("    " + "GPS Longitude: "
                        + gpsLongitudeDegrees.toDisplayString() + " degrees, "
                        + gpsLongitudeMinutes.toDisplayString() + " minutes, "
                        + gpsLongitudeSeconds.toDisplayString() + " seconds "
                        + gpsLongitudeRef);
                Coordinates[0]= gpsLatitudeDegrees.toDisplayString()+gpsLatitudeMinutes.toDisplayString()+gpsLatitudeSeconds.toDisplayString();
                Coordinates[1]= gpsLongitudeDegrees.toDisplayString()+gpsLongitudeMinutes.toDisplayString()+gpsLongitudeSeconds.toDisplayString();

            }

            System.out.println();

            final List<Item> items = jpegMetadata.getItems();
            for (int i = 0; i < items.size(); i++) {
                final Item item = items.get(i);
                System.out.println("    " + "item: " + item);
            }

            System.out.println();
        }
        return Coordinates;
    }

    private static void printTagValue(final JpegImageMetadata jpegMetadata,
                                      final TagInfo tagInfo) {
        final TiffField field = jpegMetadata.findEXIFValueWithExactMatch(tagInfo);
        if (field == null) {
            System.out.println(tagInfo.name + ": " + "Not Found.");
        } else {
            System.out.println(tagInfo.name + ": "
                    + field.getValueDescription());
        }
    }

}

 */
