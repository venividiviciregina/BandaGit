var getInput = function(input) {
    var currentInput = '#employee_form ' + input['element'] + '[name=' + input['name'] + ']';
    return $(currentInput);
};

var isFormValid = function(inputs) {
    var isFormValid = true;
    inputs.forEach(function(input) {
        var $currentInput = getInput(input);
        if ($currentInput.val() == input['restrictedValue']) {
            isFormValid = false;
            $currentInput.parent().next().show();
        }
    });
    return isFormValid;
};

var createEmployeeTable = function(employees, mapPosition) {
    var html = '';

    employees.forEach(function(employee) {
        html += '<tr>';
        html += '<th scope="row">' + employee.id + '</th>';
        html += '<td>' + employee.firstName + '</td>';
        html += '<td>' + employee.lastName + '</td>';
        html += '<td>' + employee.birthDate + '</td>';

        var position = mapPosition[employee.position];
        html += '<td>' + position + '</td>';
        html += '<td>' +
            '<button ' +
                'type="button" ' +
                'name="edit" ' +
                'id="editEmployee_'+ employee.id +'"' +
                'onclick="retrieveEmployeeDataForEdit(' + employee.id +')"' +
                '>Edit</button>' +
            '</td> ';

        html += '</tr>';
        

    });

    return html;
};



var createSelectOptions = function(options, placeholder) {
    var html = '';
    if (placeholder) {
        html += '<option value="0">' + placeholder + '</option>';
    }
    options.forEach(function (option) {
        html += '<option value="' + option.value + '">'
            + option.display
            + '</option>';
    });
    return html;
};

var createPositionMapper = function(employeePositions) {
    var mapPosition = {};
    employeePositions.forEach(function(employeePosition) {
       mapPosition[employeePosition.value] = employeePosition.display;
    });
    return mapPosition;
};

var fillEmployeeFormSelectPositionOptions = function (employeePositions) {
    $('select#position').html(createSelectOptions(employeePositions, 'Please select employee role'));
};

var fillEmployeesTable = function (mapPosition) {
    $.ajax({
        url: "/employee",
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        success: function(employees) {
            console.log(employees);
            $('table#employees tbody').html(createEmployeeTable(employees, mapPosition));
        },
        error: function() {
            alert("Can't download employees");
        }
    });
};

var cleanEmployeeForm = function($form) {
    $form.find("input[type=text], input[type=date], textarea").val("");
    $form.find("select").val(0);
};

var fillEmployeeForm = function(employee) {
    $('#employee_form input[name=id]').val(employee.id);
    $('#employee_form input[name=firstName]').val(employee.firstName);
    $('#employee_form input[name=lastName]').val(employee.lastName);
    $('#employee_form input[name=birthDate]').val(employee.birthDate);
    $('#employee_form select[name=position]').val(employee.position);
};

var retrieveEmployeeDataForEdit = function(id) {
  $.ajax({
      url: "/employee/" + id,
      type: 'GET',
      dataType: 'json',
      contentType: 'application/json',
      success: function(employee) {
          console.log(employee);
          fillEmployeeForm(employee);
          $("#employee_form input[type=submit]").val("Update employee");
      },
      error: function() {
          alert("Can't find employee with id = " + id);
      }
  });
};