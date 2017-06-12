# payloads-solr

Index

      {
        "id":"1",
        "payloads":"alice|5.0 bob",
        "_version_":1570032391365328896
      }, {
        "id":"2",
        "payloads":"alice bob",
        "_version_":1570033260964085760
      },{
        "id":"3",
        "payloads":"alice|3.0 bob",
        "_version_":1570033918717984768}
      }

http://localhost:8983/solr/payloads/select?fl=*,score&indent=on&q={!payload_score%20f=payloads%20v=alice%20func=max}&wt=json

      {
        "id":"1",
        "payloads":"alice|5.0 bob",
        "_version_":1570032391365328896,
        "score":5.0
      }, {
        "id":"3",
        "payloads":"alice|3.0 bob",
        "_version_":1570033918717984768,
        "score":3.0
      }, {
        "id":"2",
        "payloads":"alice bob",
        "_version_":1570033260964085760,
        "score":1.0
      }

http://localhost:8983/solr/payloads/select?fl=*,score&indent=on&q={!payload_score%20f=payloads%20v=alice%20func=max%20includeSpanScore=true}&wt=json

    {
        "id":"1",
        "payloads":"alice|5.0 bob",
        "_version_":1570032391365328896,
        "score":3.125
    }, {
        "id":"3",
        "payloads":"alice|3.0 bob",
        "_version_":1570033918717984768,
        "score":1.875
    }, {
        "id":"2",
        "payloads":"alice bob",
        "_version_":1570033260964085760,
        "score":0.625
    }