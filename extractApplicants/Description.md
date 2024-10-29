## Functional Requirements

A software company needs your help in extracting some information regarding the applicants to their internship program.

The source data regarding the applicants will include, for each applicant:

the name of the applicant (first name, middle names and last name);
their email address;
the date and time they delivered the solution to challenge they were given;
the score they obtained for the submitted solution (values ranging from 0 to 10).
This data will be provided in a csv (comma separated values) file similar to the example bellow:

```
name,email,delivery_datetime,score
Speranța Cruce,speranta_cruce@gmail.com,2023-01-24T20:14:53,2.33
Ionică Sergiu Ramos,chiarel@ionicaromass.ro,2023-01-24T16:32:19,9.00
Carla Ștefănescu,carlita_ste@yahoo.com,2023-01-23T23:59:01,5.20
Lucrețiu Hambare,hambare_lucretiu@outlook.com,2023-01-24T22:30:15,10
Robin Hoffman-Rus,robman@dasmail.de,2023-01-23T12:00:46,8.99
```

While processing the source data, some adjustments should be applied to the scores:


If the applicant delivered the solution in the first day, then they get 1 whole bonus point.
If the applicant delivered the solution in the second half of the last, then they get 1 whole malus point.
The information to be extracted is:

the number of unique applicants
the last names of top 3 applicants
the average score of the top half before scores adjustment
The output must be delivered in JSON format with the following properties:

- uniqueApplicants 
the number of unique applicants
value data type: integer
- topApplicants
the last names of top 3 applicants
value data type: array of strings
- averageScore
the average score of the top half before scores adjustment
value data type: decimal number with at most 2 decimals; half up rounding to be applied if needed.

## Clarifications
- The name of the applicant fallows the pattern: FirstName MiddleName1 MiddleName2...LastName.
middle names are optional, but FirstName and LastName are mandatory.
- The email address
constitutes an unique identifier for an applicant;
if the same email address appears on multiple lines, those lines should be considered as referring to the same applicant.
if an applicant appear multiple times in the file (on multiple lines), the last valid appearance should be taken into account.
in order to be valid, an email address must:
be composed of only ASCII characters,
contain only ASCII letters, digits and special characters @, ., _, -,
start with a letter
contain @ once and only once,
contain a . somewhere after @, but not right after it,
end with a letter
- The delivery date and time will be provided in local date-time ISO format, i.e. yyyy-MM-dd'T'HH:mm:ss
the date part
start with the year on 4 digits,
fallowed by the month on 2 digits,
and the day of the month on 2 digits;
separated by a dash (-)
the time part
starts with the hour on two digits, 24 hours format,
fallowed by the minutes on two digits,
and the seconds o two digits;
separated by a colon (:)
the date part is separated from the time part by a capital T character
- The score must be a decimal number, with up two 2 decimals.
The integer part will be separated from the decimals by a ..
The value must be a non-negative number with a maximum value of 10.
- Lines that contain errors and cannot be parsed should be ignored i.e. excluded from the processing.
- If the name, email, delivery date and time or score do not meet the constraints described above, then the line is considered to be invalid and thus should be ignored.
The csv file might or might not start with a header.
The top applicants are the one with the highest score after the score adjustment.
The last names of the top 3 applicants should be delivered order by their final scores in descending order.
- If 2 applicants have the same final score, in order to choose one with a higher rank, use as criteria:
the bigger initial score
the smaller delivery date
alphabetical order of the email address
- When adjusting the scores
the first day is the smallest date in the data set;
the last day is the biggest date in the data set;
the second half of the day starts with the hour 12:00:00 (mid-day).
if all applicants delivered their solution in the same day, then no adjustment will be applied.
- When computing the average score of the top half before scores adjustment
- If there is an odd number of applicants, when splitting into half, the top half should be the one with an odd number of applicants.
# Examples
## Example 1
For the input
```
name,email,delivery_datetime,score
Speranța Cruce,speranta_cruce@gmail.com,2023-01-24T20:14:53,2.33
Ionică Sergiu Ramos,chiarel@ionicaromass.ro,2023-01-24T16:32:19,9.00
Carla Ștefănescu,carlita_ste@yahoo.com,2023-01-23T23:59:01,5.20
Lucrețiu Hambare,hambare_lucretiu@outlook.com,2023-01-24T22:30:15,10
Robin Hoffman-Rus,robman@dasmail.de,2023-01-23T12:00:46,8.99
```
the output should be
```
{
"uniqueApplicants": 5,
"topApplicants": [
"Hoffman-Rus",
"Hambare",
"Ramos"
],
"averageScore": 9.33
}
```
## Example 2
For the input
```
Speranța,speranta_cruce@gmail.com,2023-01-24T20:14:53,2.33
Ionică Sergiu Ramos,chiarel@ionicaromass.ro,2023-01-24 16:32:19,9.00

Carla Ștefănescu,carlita_ste_yahoo.com,2023-01-23T23:59:01,5.20
,,,,,
Lucrețiu Hambare,hambare_lucretiu@outlook.com,2023-01-24T22:30:15,10
)_(*&^%$#@!#
Robin Hoffman-Rus,hambare_lucretiu@outlook.com,2023-01-23T12:00:46,8.99
```
the output should be
```
{
"uniqueApplicants": 1,
"topApplicants": [
"Hoffman-Rus"
],
"averageScore": 8.99
}
```
## Technical Requirements
The implementation should be done in Java.

The implementation should absolutely include a class.
```
public class ApplicantsProcessor {

    /**
     * 
     * @param csvStream input stream allowing to read the CSV input file
     * @return the processing output, in JSON format
     */
public String processApplicants(InputStream csvStream) {
// Your implementation goes here
}
}
```
The class ApplicantsProcessor described above is mandatory, but this does not mean that it should be the only class in the implementation.

The method processApplicants described above is mandatory, but this does not mean that it should be the only method of ApplicantsProcessor.

You are free to use any third party library, as long as:

- it suits the purpose;
- it is open-sourced; 
- it is available on maven central repository.