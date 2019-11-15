$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/myproject/features/registration.feature");
formatter.feature({
  "name": "Registration",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "User should be able to register to the application with proper data",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "user goes to the http://automationpractice.com main page",
  "keyword": "Given "
});
formatter.match({
  "location": "GoToSteps.goToThePage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he goes to the authentication page",
  "keyword": "When "
});
formatter.match({
  "location": "GoToSteps.goToTheAuthenticationPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he fills the form with default data",
  "keyword": "And "
});
formatter.match({
  "location": "RegistrationSteps.registerUser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he is logged in and my account page is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.userShouldBeLoggedIn()"
});
formatter.result({
  "status": "passed"
});
});