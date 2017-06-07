//
//  ViewController.swift
//  TestCode
//
//  Created by cssummer17 on 6/6/17.
//  Copyright © 2017 cssummer17. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var recordingLabel: UILabel!
    
    @IBOutlet weak var recordButton: UIButton!
    
    @IBOutlet weak var stopRecordButton: UIButton!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }
    
    override func viewWillAppear(_ animated: Bool) {
        stopRecordButton.isEnabled = false
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    @IBAction func recordAudio(_ sender: Any) {
        print("The record button was pressed.")
        recordingLabel.text = "recording in progress"
        stopRecordButton.isEnabled = true
        recordButton.isEnabled = false
    }
    
    @IBAction func stopRecord(_ sender: Any) {
        print("You just stopped recording.")
        recordButton.isEnabled = true
        stopRecordButton.isEnabled = false
    }

}

