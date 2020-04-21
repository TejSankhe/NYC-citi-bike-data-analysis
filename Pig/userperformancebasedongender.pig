citibikedata = LOAD '/project/data' USING org.apache.pig.piggybank.storage.CSVExcelStorage(',', 'NO_MULTILINE', 'NOCHANGE', 'SKIP_INPUT_HEADER') AS (tripduration, starttime, stoptime, start_station_id, start_station_name, start_station_lat, start_station_lon, end_station_id, end_station_name, end_station_lat, end_station_lon, bikeid, usertype, birt_year, gender);
genderGrp = GROUP citibikedata by gender;
avgTripduration = FOREACH genderGrp GENERATE group, AVG(citibikedata.tripduration) as avg;
store avgTripduration INTO '/project/output_pig/avgTripduration_gender' USING PigStorage(',');
