/**
 * @license
 * Copyright (c) 2014, 2022, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */
/*
 * Your dashboard ViewModel code goes here
 */
define(['../accUtils',"exports", "knockout", "ojs/ojbootstrap", "ojs/ojarraydataprovider", 
"ojs/ojtable","ojs/ojactioncard", "ojs/ojbootstrap", "ojs/ojknockout","ojs/ojbutton", "ojs/ojinputtext"],

 function(accUtils,exports, ko, ojbootstrap_1, ArrayDataProvider) {

  
    function DashboardViewModel() {
      var url = 'http://localhost:9191/Assignment/StudentController';

    // Add/Update Input Student Variables
     this.studentIdForAdd = ko.observable();
     this.studentNameForAdd = ko.observable();
     console.log(this.studentIdForAdd());

    // Add Record Button Action Start
    this.addstudentbuttonAction = (event) => {
      var idForAdd = this.studentIdForAdd();
      var nameForAdd = this.studentNameForAdd();
      var route = 'AddUpdate'

      console.log(idForAdd);
      console.log(nameForAdd);
/*
      $.ajax({
        url     : 'http://localhost:9191/Assignment/addStudent',
        method     : 'POST',
        data     : {studentId:idForAdd, studentName : nameForAdd},
        success: function (data) {   
            console.log(data);
            alert(data.message);
          
        },
        error : function(jqXHR, exception){
        console.log('Error occured!!');
        console.log('Error occured!!');
            var errMsg =' ';
            if(jqXHR.status == 0){errMsg='Oops! Network Problem';}
            else if(jqXHR.status==404){errMsg='Could not find the requested page';}
            else if(jqXHR.status==500){errMsg='Internal Server Error. Try again later!';}
            alert(errMsg);
        }
        }); 
        
        */

        $.ajax({
          url     : url,
          method     : 'POST',
          data     : {route:'AddUpdate',studentId:idForAdd, studentName : nameForAdd},
          success: function (data) {   
              console.log(data);
              alert(data.successMessage);
            
          },
          error : function(jqXHR, exception){
          console.log('Error occured!!');
          console.log('Error occured!!');
              var errMsg =' ';
              if(jqXHR.status == 0){errMsg='Oops! Network Problem';}
              else if(jqXHR.status==404){errMsg='Could not find the requested page';}
              else if(jqXHR.status==500){errMsg='Internal Server Error. Try again later!';}
              alert(errMsg);
          }
          }); 
        

    };          // Add Student Record Button Action End

    

    // Delete Student Input Variables
    this.studentIdForDelete = ko.observable();
    // Delete Student Record Button Action Start
    this.deletestudentbuttonAction = (event) => {
      console.log(this.studentIdForDelete());
      var idForDelete = this.studentIdForDelete();

      /*
      $.ajax({
        url     : 'http://localhost:9191/Assignment/deleteStudent',
        method     : 'POST',
        data : {studentIdForDelete:idForDelete},
        success: function (result) {   
          console.log(result);
          alert(result.message);
        },
      error : function(jqXHR, exception){
          console.log('Error occured!!');
          console.log('Error occured!!');
            var errMsg =' ';
            if(jqXHR.status == 0){errMsg='Oops! Network Problem';}
            else if(jqXHR.status==404){errMsg='Could not find the requested page';}
            else if(jqXHR.status==500){errMsg='Internal Server Error. Try again later!';}
            alert(errMsg);
        }
      }); */

      $.ajax({
        url     : url, method     : 'POST',
        data : {route:'Delete', studentId:idForDelete},
        success: function (data) {   
          console.log(data);
          alert(data.successMessage);
          
        },
      error : function(jqXHR, exception){
          console.log('Error occured!!');
          console.log('Error occured!!');
            var errMsg =' ';
            if(jqXHR.status == 0){errMsg='Oops! Network Problem';}
            else if(jqXHR.status==404){errMsg='Could not find the requested page';}
            else if(jqXHR.status==500){errMsg='Internal Server Error. Try again later!';}
            alert(errMsg);
        }
      });
      
     };  // Delete Student Record Button Action End

     // Search by Id
     this.studentIdForSearch = ko.observable();
     //this.studentdataprovider =[];
     var serverdataForSearch= ko.observableArray();
     this.searchstudentbuttonAction = (event) => {
      var idForSearch = this.studentIdForSearch();
      
      console.log('Fetching Student by ID');
      
      /*
      $.ajax({
        url     : 'http://localhost:9191/Assignment/getStudentById',
        method     : 'POST',
        dataType: 'json',
        async:'false',
        data : {sstudentId:idForSearch},
        success: function (data) {   // success callback function
            serverdataForSearch.push(data);
            console.log(serverdataForSearch);
        },
      error : function(jqXHR, exception){
          console.log('Error occured!!');
          console.log('Error occured!!');
            var errMsg =' ';
            if(jqXHR.status == 0){errMsg='Oops! Network Problem';}
            else if(jqXHR.status==404){errMsg='Could not find the requested page';}
            else if(jqXHR.status==500){errMsg='Internal Server Error. Try again later!';}
            alert(errMsg);
        }
    });

    */


    $.ajax({
      url     : url,
      method     : 'POST',
      dataType: 'json',
      async:'false',
      data : {route:'GetById',studentId:idForSearch},
      success: function (data) {   // success callback function
        console.log(data);
          serverdataForSearch.push(data);
          console.log(serverdataForSearch);
      },
    error : function(jqXHR, exception){
        console.log('Error occured!!');
        console.log('Error occured!!');
          var errMsg =' ';
          if(jqXHR.status == 0){errMsg='Oops! Network Problem';}
          else if(jqXHR.status==404){errMsg='Could not find the requested page';}
          else if(jqXHR.status==500){errMsg='Internal Server Error. Try again later!';}
          alert(errMsg);
      }
  });
    };

    this.studentdataprovider = new ArrayDataProvider(serverdataForSearch, {
      keyAttributes: "studentId",
      implicitSort: [{ attribute: "studentId", direction: "ascending" }],
    });




 
    


            




      this.connected = () => {
        accUtils.announce('Dashboard page loaded.', 'assertive');
        document.title = "Dashboard";
        // Implement further logic if needed
      };

      /**
       * Optional ViewModel method invoked after the View is disconnected from the DOM.
       */
      this.disconnected = () => {
        // Implement if needed
      };

      
      this.transitionCompleted = () => {
        // Implement if needed
      };
    }

    return DashboardViewModel;
  }
);
