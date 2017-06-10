# TinyUrl_LogicMonitor

This project encompasses a RESTfull Client interacting with backend RESTful web uservices developed using Jersey to generate tinyUrl 
for any given longUrl.

Expander functionality is also provided where any generated tinyUrl will expand back to the original longer url.

Example: 

LongUrl: http://www.facebook.com/freakyabir
Generated 6-character long: tyU89l

Tinyrl: http://baseurl.com/tyU89l


Design Approach

TinyUrl Generation

Given a long url, a shortened url can be formed using alphabetical letters and numbers[a-zA-z0-
9]. So, we have 26+26+10 = 62 different characters to choose from to create a tinyurl.
Suppose, if we decide that the tinyurl would be of length 6. And if we append the random
tinyurl generated to a base url like(www.tinyurl.com), we can effectively create 62^6 ~= 56
billion unique urls.

Requirements: 
The given url should be fully qualified url (contains http:// or https://)

DataStructure

Basically my approach is to store the given url and the generated tinyUrl based on the business
logic provided in to a HashMap<String,String> baseMap as a key-value pair. So the key would
the longUrl and the value would be the corresponding tinyUrl.

Uniqueness

With each request of tinyUrl creation, the code will first check whether the key(longUrl) already
exists in the baseMap or not. If it is present, it will simply return the corresponding tinyUrl. And
hence, it prevents from creating tinyUrl for already used longUrls

Again, if a new longUrl used and a 6 character long tinyUrl is generated, we check it against the
baseMap whether this value(tinyUrl) is already generated for any other longUrl or not. If it is
present, then we regenerate the tinyUrl else we store it into the hashmap.

Data Persistence & Consistency

In order to persist the data and maintain consistency between two service calls, we persist the
map data into the file system (map.txt file) and reads it back from the file when required. We
can opt for storing the data in the database instead of storing it into in-memory data structures
or can store the data in any cloud based storage services.

Scalability

The services have been developed to a scale and can be extended to serve requests in
distributed systems. We can persist the data in distributed databases using distributed sharding
techniques adding an additional data persistence layer. Multiple machines may be required to
store all the mappings and since they will be geographically distributed adopting an incremental
id approach would not work.

Cost

Each entry is stored as <LongURL, TINYURL> where TINYURL is a 6-character string. Assuming
max URL length is 2000 characters, then each entry takes 6 * 4 bytes + 2000 * 4 bytes = 8.0 KB.
If we store a million URL mappings, we need around 8.0GB storage.

Capability of BlackList URLS

We can store all the black list urls in our storage media/ database and we can check whether a
generated tinyUrl is blacklisted or not. If it is blacklisted, we can re-generate the tinyUrl.
