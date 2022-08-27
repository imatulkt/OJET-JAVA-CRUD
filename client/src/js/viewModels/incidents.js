/**
 * @license
 * Copyright (c) 2014, 2022, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */
/*
 * Your incidents ViewModel code goes here
 */
define(['../accUtils',"require", "exports", "knockout",  "ojs/ojbootstrap", "ojs/ojarraydataprovider", 
"ojs/ojtable", "ojs/ojknockout","ojs/ojbutton", "ojs/ojinputtext"],

 function(accUtils,require, exports, ko, ojbootstrap_1, ArrayDataProvider) {

  
    function IncidentsViewModel() {
      this.studentId = ko.observable();
      //this.studentdataprovider =[];
      var serverdata= ko.observableArray();

      this.buttonAction = (event) => {
        var id = this.studentId();
        
        console.log('Fetching Student by ID');

        $.ajax({
          url     : 'http://localhost:9191/Assignment/getStudentById',
          method     : 'POST',
          dataType: 'json',
          data : {sstudentId:id},
          success: function (data) {   // success callback function
              serverdata.push(data);
              console.log(serverdata);
          },
        error : function(jqXHR, exception){
            console.log('Error occured!!');
          }
      });
      };


  // Populating the table
  this.studentdataprovider = new ArrayDataProvider(serverdata, {
    keyAttributes: "studentId",
    implicitSort: [{ attribute: "studentId", direction: "ascending" }],
  });
      


      this.connected = () => {
        accUtils.announce('Incidents page loaded.', 'assertive');
        document.title = "Incidents";
        // Implement further logic if needed
      };

      /**
       * Optional ViewModel method invoked after the View is disconnected from the DOM.
       */
      this.disconnected = () => {
        // Implement if needed
      };

      /**
       * Optional ViewModel method invoked after transition to the new View is complete.
       * That includes any possible animation between the old and the new View.
       */
      this.transitionCompleted = () => {
        // Implement if needed
      };
    }

    /*
     * Returns an instance of the ViewModel providing one instance of the ViewModel. If needed,
     * return a constructor for the ViewModel so that the ViewModel is constructed
     * each time the view is displayed.
     */
    return IncidentsViewModel;
  }
);
