/**
 * @license
 * Copyright (c) 2014, 2022, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */
/*
 * Your about ViewModel code goes here
 */
define(['../accUtils',"exports", "knockout", "ojs/ojbootstrap", "ojs/ojknockout","ojs/ojbutton", "ojs/ojinputtext"],
 function(accUtils,exports, ko, Bootstrap) {
    function AboutViewModel() {
     this.studentId = ko.observable();

     this.buttonAction = (event) => {

      //Checking variable
      console.log(this.studentId());
      var id = this.studentId();
      
     
      $.ajax({
        url     : 'http://localhost:9191/Assignment/deleteStudent',
        method     : 'POST',
        data : {studentIdForDelete:id},
        success: function (result) {   
          console.log(result);
          alert(result.message);
        },
      error : function(jqXHR, exception){
          console.log('Error occured!!');

          
        }
      });
      
     };
     
      




      this.connected = () => {
        accUtils.announce('About page loaded.', 'assertive');
        document.title = "About";
        // Implement further logic if needed
      };

      
      this.disconnected = () => {
        // Implement if needed
      };

      
      this.transitionCompleted = () => {
        // Implement if needed
      };
    }

    
    return AboutViewModel;
  }
);
