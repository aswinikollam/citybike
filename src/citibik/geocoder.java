package citibik;

public class geocoder {


@Override
public void onLocationChanged(Location location) {

    Geocoder geocoder;
    List<Address> addresses;
    geocoder = new Geocoder(this, Locale.getDefault());

    latitude = location.getLatitude();
    longitude = location.getLongitude();

    Log.e("latitude", "latitude--" + latitude);

    try {
        Log.e("latitude", "inside latitude--" + latitude);
        addresses = geocoder.getFromLocation(latitude, longitude, 1);

        if (addresses != null && addresses.size() > 0) {
            String address = addresses.get(0).getAddressLine(0); 
            String city = addresses.get(0).getLocality();
            String state = addresses.get(0).getAdminArea();
            String country = addresses.get(0).getCountryName();
            String postalCode = addresses.get(0).getPostalCode();
            String knownName = addresses.get(0).getFeatureName(); 

            locationTxt.setText(address + " " + city + " " + country);
        }
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}
}