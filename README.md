simple web scraper

Parse sites, find table data and save data to csv files

Multi thread command-line tool

Property file
- parent utl
- child url filter (RegExp)
- depth
- keys to find table
- path to save files


Flow
- go to parent url
- create list child links
- parse child link
    - find tables 
    - save to file

Application parts
- parse url for links
- parse url for tables
- save data to file


url -> html -> resources -> save to files
            -> text -> parsed text