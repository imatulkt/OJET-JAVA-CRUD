/**
 * @license
 * Copyright (c) 2014, 2022, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */
/*
 * Your customer ViewModel code goes here
 */
define(['../accUtils', "require", "exports", "knockout",  "ojs/ojbootstrap", "ojs/ojarraydataprovider", 
"ojs/ojtable", "ojs/ojknockout","ojs/ojbutton", "ojs/ojinputtext"],
function(accUtils,require, exports, ko, ojbootstrap_1, ArrayDataProvider) {
    function CustomerViewModel() {
      var url = 'http://localhost:9191/Assignment/StudentController';

      var serverdata= ko.observableArray();
    
      this.viewallstudentbuttonAction = (event) => {

        console.log("Fetching all students");
        $.ajax({
          url     : url,
          method     : 'POST',
          dataType: 'json',
          data:{route:'ViewAll'},
          success: function (data) {   // success callback function
    
            for (var i=0; i<data.length; i++) {
              serverdata.push(data[i])
             }
          console.log(data);
          console.log(serverdata);
          },
        error : function(jqXHR, exception){
            console.log('Error occured!!');
            var errMsg =' ';
            if(jqXHR.status == 0){errMsg='Oops! Network Problem';}
            else if(jqXHR.status==404){errMsg='Could not find the requested page';}
            else if(jqXHR.status==500){errMsg='Internal Server Error. Try again later!';}
            alert(errMsg);
        }
        });


      };
     

      this.studentdataprovider = new ArrayDataProvider(serverdata, {
        keyAttributes: "studentId",
        implicitSort: [{ attribute: "studentId", direction: "ascending" }],
      });





     // var studentData=[{"studentId":1,"studentName":"Atul"},{"studentId":2,"studentName":"Jai"}];
     // console.log(serverdata);
     


      
      
      this.disconnected = () => {
        // Implement if needed
      };

      
      this.transitionCompleted = () => {
        // Implement if needed
      };
    }

  
    return CustomerViewModel;
  }
);
