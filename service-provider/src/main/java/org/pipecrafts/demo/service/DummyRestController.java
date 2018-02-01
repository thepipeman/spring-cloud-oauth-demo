package org.pipecrafts.demo.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by Aaron Rasing on 2/1/18.
 */
@RestController
@RequestMapping("api/v1/")
public class DummyRestController {

    @RequestMapping("dummy")
    public ResponseEntity<ArrayList<DummyData>> getDummyData(){
        ArrayList<DummyData> dummyList = new ArrayList<>();
        dummyList.add(new DummyData(1, "data 1"));
        dummyList.add(new DummyData(2, "data 2"));

        return new ResponseEntity<ArrayList<DummyData>>(dummyList, HttpStatus.OK);
    }



    class DummyData{
        private int id;

        private String desc;

        public DummyData(int id, String desc) {
            this.id = id;
            this.desc = desc;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

}
