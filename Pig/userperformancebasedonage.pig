citibikedata = LOAD '/project/data' USING org.apache.pig.piggybank.storage.CSVExcelStorage(',', 'NO_MULTILINE', 'NOCHANGE', 'SKIP_INPUT_HEADER') AS (tripduration, starttime, stoptime, start_station_id, start_station_name, start_station_lat, start_station_lon, end_station_id, end_station_name, end_station_lat, end_station_lon, bikeid, usertype, birth_year, gender);
sub_data = FOREACH citibikedata GENERATE SUBTRACT(2019,birth_year) as age;
store sub_data INTO '/project/output_pig/avgTripduration_age' USING PigStorage(',');
