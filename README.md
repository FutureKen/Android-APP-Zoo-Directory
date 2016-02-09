# Android-APP-Zoo-Directory
This app provides a listing of animals, details of each animal, and basic information about the zoo.

<h2>1. Animal listing activity </h2>

This zoo have  6 animals. Each row in the list  have: 

<ul>
<li>a thumbnail picture of the animal </li>
<li>the name of the animal </li>
</ul>

This should be implemented as a ListView. When any part of a row is clicked, it should launch the details activity for the corresponding animal (described next). 

<h2>2. Animal detail activity</h2>

The animal detail activity shows details on the animal chosen in the list. The activity should show: 
<ul>
<li>The name of the animal </li>
<li>A large image of the animal </li>
<li>A short description of the animal </li>
</ul>

The same detail activity code should be reused for each animal, but with different content, obviously 
 
<h2>3. Zoo information activity </h2>

The zoo information activity should have: 
<ul>
<li>The name of the zoo </li>
<li>A phone number, represented as Button or a TextView. When clicked, the phone number of the zoo (888-8888) should be dialed. You can use the Intent.ACTION_CALL intent for this. </li>
</ul>

This activity should be triggered by one of the menu items (see the "Menu Items" section below). 
Menu Items 

The ActionBar should remain persistent throughout the app. The overflow menu should have two items: 

<ul>
<li>Information. This should launch the zoo information activity (described above). </li>
<li>Uninstall. This should call an intent to uninstall the app. You can use the Intent.ACTION_DELETE intent for this.</li>
</ul>
	 
The menu items listed above should appear in the overflow menu and not as buttons in the action bar. This is because only frequent, important, or typical actions are supposed to appear as buttons in the ActionBar. 

<h3>Dialog Box </h3>
When the user clicks on the last animal in the animal listing activity, an alert box should pop-up, warning the user that the animal is very scary and asking the user if they want to proceed. If the user clicks "Yes", then the app should proceed as normal. If the user clicks "No", then the app should remain on the same activity. 
<h3>Favorite Toggle Icon </h3>
In the Animal Listing Activity, add a “Favorite” icon towards the right side of each row.  Initially by default each row is a non-favorite. When user clicks on the icon, it changes to mark that row as user’s favorite.  Clicking again will turn the icon back to non-favorite state.  This is similar to gmail star feature. 
