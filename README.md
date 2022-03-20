# <img align="center" alt="Coding" width="100%" src="https://64.media.tumblr.com/181869dcd9a34d2ac699c97ee2f25c1b/tumblr_n3usgtGccQ1ts99vgo1_500.gifv">
<h1 align="center">The Rick and Morty app</h1>

# Introduction

Hi 👋, my name is  Winston Roemello White and I am Software Engineer. The application I have created is called
"The Rick and Morty App". This application provides you with a small databse of characters that 
you can select from and find out there status of living. 


# Architectural Overview 

```MainActivity.kt ```
The purpose of this file is to handle any UI changes if a user decides to logout, the business logic is being taken care of in the “MainActivityPresenterFile”. and views list of characters from the CharactersListAdapter.kt file. And the MainActivityContract file is being used to establish communication between the view presenter and the presenter model using an interface. Defining abstract methods which will be used in the view model and presenter class. 

```MainActivityContract.kt```
The purpose of this file is to define methods that will be used in the respected files. We have a View interface with methods defined if it’s successful show the list of characters. 
Another interface called Presenter which defines the logout method used in MainActivity.
And the suspended method called consumeEndpoint that is used in MainActivity Presenter.

```MainActivityPresenter.kt```
The purpose of this file is to handle all of the business logic. This file makes the call to the graphql endpoint.  We instantiate the apolloClient and then make the query.  Also in this file we create the logic for the logout function used. 

```DetailsActivity.kt```
This file is hosting a fragment, all things being displayed are within that navHostFragment and all of the business logic is stored in the DetailsActivityPresenter. 
All this file is doing is receiving a character object from the main activity, upon receiving that object it will be passed into the fragment and displayed in the fragment with the help of the DetailsActvityPresenter. 

```DetailsActivityPresenter.kt```
This file contains the business logic, and all its doing is initializing the navigation graph of the navigation component. 

```DetailsActivityContract.kt```
This file defines methods that will be used in the View and Presenter file. As of now the Presenter interface in this contract file is defining the startIgniting method to be used in the DetailsActivityPresenter. 

```DetailsFragment.kt```
This file is used to host information about the characters status and image of the character. As well as the back arrow which is displayed upon clicking on a character from the main list of characters. The back arrow is displayed and clicked on if a user wants to go back to previous activity. In addition to that the user is also able to logout from this current screen. All of the business logic is being stored in the DetailsFragmentPresenter file.

```DetailsFragmentPresenter.kt``` 
This file is handling all of the business logic. This file is receiving data as an argument from DetailsActivity. It is also receiving the object of character from data class. The data class is parcelized which then gives us a parcelable object that can be passed as an argument. Character is being received from DetailActivity and the DetailActivity is being received from MainActivity. 

```DetailsFragmentContract.kt```
This file defines the populate data method in the presenter interface that will be used in the DetailsFragmentPresenter. 

```LoginActivity.kt```
 This file contains a button for a user to login to the application. All of the business logic is in the LoginActivityPresenter. 
 
```LoginActivityContract.kt```
This file two methods defined in the presenter interface which are checkLogin and makeLogin method which is used in the LoginActivityPresenter

```LoginActivityPresenter.kt```
This file contains all of the business logic. This file checks to see if the user is logged in or not and handles the logic for if a user logged in or not. 

```Character.kt```
This is a data class, used to pass data from MainActivity to DetailsActivity and then from DetailsActivity to the details fragment. The data class is parcelized so we can pass its objects as arguments. 

```CharactersListAdapter.kt```
This adapter is for the recycler view, it displays items loaded into an adapter. The items loaded into the adapter are  [id, name, species, image, character].

# Architectural Design Pattern
The design pattern that I used to build this project was MVP (Model View Presenter). 
My reason behind using this pattern is to divide the application into smaller sections which provides easier readability as well as less bugs. I can also debug my application more efficiently.
As you can see from the “Architectural Overview”, how I structured my files so that the responsibility is split. The ```Model``` represents the class that describes the business logic and data. And defines the business rules for data how they can be manipulated. In the ```Presenter```, we receive the inputs from the users from ```View```, and then with the assistance from the ```Model``` we are able to process the users data and pass those results back to the ```View```.  The relationships are close among files that have the same name but due to the design pattern they all run different tasks. So if something goes wrong in the application I know exactly where the root of the problem could be. 

# Flow of Application
#### User logs into application
<img width="273" alt="Screen Shot 2022-03-20 at 2 01 48 PM" src="https://user-images.githubusercontent.com/54634093/159176386-66bea755-92fc-44ad-bded-f9fc1f3b8738.png">

#### User can view a list of Characters which are scrollable
<img width="265" alt="Screen Shot 2022-03-20 at 1 31 36 PM" src="https://user-images.githubusercontent.com/54634093/159176437-e239fe50-cc29-4cf5-872b-a30f46f6473f.png">


#### We can select on a Character and view there image and life status
<img width="261" alt="Screen Shot 2022-03-20 at 1 32 11 PM" src="https://user-images.githubusercontent.com/54634093/159176517-76cb690a-b63b-4138-ac01-91632800de60.png">

#### We can logout back to the login screen
<img width="273" alt="Screen Shot 2022-03-20 at 2 01 48 PM" src="https://user-images.githubusercontent.com/54634093/159176386-66bea755-92fc-44ad-bded-f9fc1f3b8738.png">

#### We can go back to view the previous activity
<img width="262" alt="Screen Shot 2022-03-20 at 1 31 58 PM" src="https://user-images.githubusercontent.com/54634093/159176495-fd639c99-399d-42e5-877a-36c6a343fac1.png">


# Tools used to build and design application:
<p align="left"> <a href="https://developer.android.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/android/android-original-wordmark.svg" alt="android" width="40" height="40"/> </a> <a href="https://www.figma.com/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/figma/figma-icon.svg" alt="figma" width="40" height="40"/> </a> <a href="https://kotlinlang.org" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/kotlinlang/kotlinlang-icon.svg" alt="kotlin" width="40" height="40"/> </a> </p>

